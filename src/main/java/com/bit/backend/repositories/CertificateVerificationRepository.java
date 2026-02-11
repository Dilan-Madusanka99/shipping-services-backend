package com.bit.backend.repositories;

import com.bit.backend.entities.CertificateVerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CertificateVerificationRepository extends JpaRepository<CertificateVerificationEntity, Long> {
    Optional<List<CertificateVerificationEntity>> findBySidNo(String sidNo);
}

