package com.bit.backend.repositories;

import com.bit.backend.entities.CertificatesRegistrationEntity;
import com.bit.backend.entities.OtherDetailsRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CertificatesRegistrationRepository extends JpaRepository<CertificatesRegistrationEntity, Long> {
    Optional<List<CertificatesRegistrationEntity>> findBycName(String cName);
    Optional<List<CertificatesRegistrationEntity>> findBysidNo(String sidNo);
    List<CertificatesRegistrationEntity> findBycNo(String cNo);
    Optional<List<CertificatesRegistrationEntity>> findBySidNo(String sidNo);
    @Modifying
    @Query("UPDATE CertificatesRegistrationEntity c " +
            "SET c.verificationStatus = 'Expired' " +
            "WHERE c.cExpiredDate < CURRENT_DATE " +
            "AND c.verificationStatus <> 'Expired'")
    int markExpiredCertificates();
}
