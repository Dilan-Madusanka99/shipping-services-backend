package com.bit.backend.repositories;

import com.bit.backend.entities.CertificatesRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CertificatesRegistrationRepository extends JpaRepository<CertificatesRegistrationEntity, Long> {
    Optional<CertificatesRegistrationEntity> findByCName(String cName);

}
