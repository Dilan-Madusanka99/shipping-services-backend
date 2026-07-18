package com.bit.backend.schedulers;

import com.bit.backend.repositories.CertificatesRegistrationRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDate;

@Component
public class CertificateExpiryScheduler {
    private final CertificatesRegistrationRepository certificatesRegistrationRepository;

    public CertificateExpiryScheduler(CertificatesRegistrationRepository certificatesRegistrationRepository) {
        this.certificatesRegistrationRepository = certificatesRegistrationRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runOnStartup() {
        markExpiredCertificates();
    }

    @Scheduled(cron = "${certificate.expiry.cron:0 59 0 * * *}", zone = "Asia/Colombo")
    public void markExpiredCertificates() {
        int updated = certificatesRegistrationRepository.markExpiredCertificates();
    }
}
