package com.bit.backend.repositories;

import com.bit.backend.entities.OnboardCrewRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OnboardCrewRegistrationRepository extends JpaRepository<OnboardCrewRegistrationEntity, Long> {
    Optional<OnboardCrewRegistrationEntity> findBySidNo(String sidNo);
}
