package com.bit.backend.repositories;

import com.bit.backend.entities.OtherDetailsRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtherDetailsRegistrationRepository extends JpaRepository<OtherDetailsRegistrationEntity, Long> {
    Optional<OtherDetailsRegistrationEntity> findByPpNo(String ppNo);
}
