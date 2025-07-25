package com.bit.backend.repositories;

import com.bit.backend.entities.CertificatesRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CertificatesRegistrationRepository extends JpaRepository<CertificatesRegistrationEntity, Long> {
    Optional<List<CertificatesRegistrationEntity>> findBycName(String cName);
    Optional<List<CertificatesRegistrationEntity>> findBysidNo(String sidNo);
    List<CertificatesRegistrationEntity> findBycNo(String cNo);
}
