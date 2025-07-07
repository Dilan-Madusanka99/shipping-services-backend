package com.bit.backend.repositories;

import com.bit.backend.entities.CertificateVerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateVerificationRepository extends JpaRepository<CertificateVerificationEntity, Long> {
}
