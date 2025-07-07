package com.bit.backend.repositories;

import com.bit.backend.entities.VesselRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VesselRegistrationRepository extends JpaRepository<VesselRegistrationEntity, Long> {}
