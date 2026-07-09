package com.bit.backend.schedulers;

import com.bit.backend.repositories.CertificatesRegistrationRepository;
import jakarta.transaction.Transactional;
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

    @Scheduled(cron = "${certificate.expiry.cron:0 59 0 * * *}", zone = "Asia/Colombo")
    @Transactional
    public void markExpiredCertificates() {
        int updated = certificatesRegistrationRepository.markExpiredCertificates();
    }
}
