package com.bit.backend.repositories;

import com.bit.backend.entities.SupplierRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRegistrationRepository extends JpaRepository<SupplierRegistrationEntity, Long> {
    Optional<SupplierRegistrationEntity> findBySupplierNo(String supplierNo);
}
