package com.bit.backend.repositories;

import com.bit.backend.entities.JobPostingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingRepository extends JpaRepository<JobPostingEntity, Long> {
    List<JobPostingEntity> findByJobStatus(String status);
}
