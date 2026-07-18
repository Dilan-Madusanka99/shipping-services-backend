package com.bit.backend.schedulers;

import com.bit.backend.entities.CertificatesRegistrationEntity;
import com.bit.backend.entities.NotificationEntity;
import com.bit.backend.entities.SeafarersEntity;
import com.bit.backend.entities.User;
import com.bit.backend.repositories.CertificatesRegistrationRepository;
import com.bit.backend.repositories.NotificationRepository;
import com.bit.backend.repositories.SeafarersRepository;
import com.bit.backend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CertificateExpiryScheduler {
    private final CertificatesRegistrationRepository certificatesRegistrationRepository;
    private final NotificationRepository notificationRepository;
    private final SeafarersRepository safarersRepository;
    private final UserRepository userRepository;
    private final SimpMessagingTemplate messagingTemplate;

    private static final String STATUS_EXPIRED = "Expired";

    public CertificateExpiryScheduler(CertificatesRegistrationRepository certificatesRegistrationRepository,
                                      NotificationRepository notificationRepository,
                                      SeafarersRepository safarersRepository,
                                      UserRepository userRepository,
                                      SimpMessagingTemplate messagingTemplate) {
        this.certificatesRegistrationRepository = certificatesRegistrationRepository;
        this.notificationRepository = notificationRepository;
        this.safarersRepository = safarersRepository;
        this.userRepository = userRepository;
        this.messagingTemplate = messagingTemplate;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runOnStartup() {
        markExpiredCertificates();
    }

    @Scheduled(cron = "${certificate.expiry.cron:0 59 0 * * *}", zone = "Asia/Colombo")
    public void markExpiredCertificates() {
//        int updated = certificatesRegistrationRepository.markExpiredCertificates();
        Date cutoff = startOfTomorrow();  // anything expiring today or earlier
        List<CertificatesRegistrationEntity> expired =
                certificatesRegistrationRepository.findNewlyExpired(cutoff);

        if (expired.isEmpty()) {
            return;
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        for (CertificatesRegistrationEntity cert : expired) {
            cert.setVerificationStatus(STATUS_EXPIRED);
            NotificationEntity notificationEntity = new NotificationEntity();
            String userName = resolveUsername(cert.getSidNo(), notificationEntity);
            notificationEntity.setReadStatus(false);
            notificationEntity.setMessage( "Certificate expired, Your certificate \"" + cert.getcName() + "\" (No: " + cert.getcNo()
                            + ") expired on " + df.format(cert.getcExpiredDate())
                            + ". Please renew and re-upload it.");
            notificationEntity.setTimeStamp(new Date());
            notificationEntity.setType("CERTIFICATE_EXPIRY");
            notificationEntity.setTitle("Certificate Expired");
            NotificationEntity savedNotificationDto = notificationRepository.save(notificationEntity);
            messagingTemplate.convertAndSend("/topic/user." + userName, savedNotificationDto);
        }

        certificatesRegistrationRepository.saveAll(expired);

        // One summary notification to staff instead of one per certificate
//        notificationService.notifyAll(
//                "Certificates expired",
//                expired.size() + " certificate(s) were marked as expired today.",
//                NotificationType.CERTIFICATE_EXPIRY,
//                "/certificates?status=EXPIRED");
    }

    private Date startOfTomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    private String resolveUsername(String sidNo, NotificationEntity notificationEntity) {
        Long userId;
        String userName = "";
        Optional<SeafarersEntity> optionalSeafarersEntity = safarersRepository.findById(Long.parseLong(sidNo));

        if (optionalSeafarersEntity.isPresent()) {
            SeafarersEntity seafarersEntity = optionalSeafarersEntity.get();
            Optional<User> optionalUser = userRepository.findBySid(seafarersEntity.getSidNo());
            if (optionalUser.isPresent()) {
                userId = optionalUser.get().getId();
                userName = optionalUser.get().getLogin();
                notificationEntity.setTargetUser(userId);
            }
        }

        return userName;
    }
}
