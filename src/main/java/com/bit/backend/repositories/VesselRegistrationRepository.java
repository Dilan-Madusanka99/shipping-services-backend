package com.bit.backend.repositories;

import com.bit.backend.entities.VesselRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VesselRegistrationRepository extends JpaRepository<VesselRegistrationEntity, Long> {
    Optional<VesselRegistrationEntity> findByImoNo(String imoNo);
}
