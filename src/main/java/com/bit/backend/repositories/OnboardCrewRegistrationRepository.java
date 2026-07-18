package com.bit.backend.repositories;

import com.bit.backend.entities.OnboardCrewRegistrationEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OnboardCrewRegistrationRepository extends JpaRepository<OnboardCrewRegistrationEntity, Long> {

    Optional<List<OnboardCrewRegistrationEntity>> findBySidNo(String sidNo);
    List<OnboardCrewRegistrationEntity> findByStatus(String status);

    @Modifying
    @Transactional
    @Query("UPDATE OnboardCrewRegistrationEntity o " +
            "SET o.status = 'Inactive' " +
            "WHERE o.signOffDate < :today " +
            "AND o.status <> 'Inactive'")
    int markExpiredAsInactive(@Param("today") Date today);
}
