package com.bit.backend.repositories;

import com.bit.backend.entities.JobApplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobApplyRepository extends JpaRepository<JobApplyEntity, Long> {
    Optional<JobApplyEntity> findByJobIdAndSeafarerId(Long jobId, Long seafarerId);
}
