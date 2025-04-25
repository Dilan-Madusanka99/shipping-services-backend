package com.bit.backend.repositories;

import com.bit.backend.entities.JobPostingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPostingEntity, Long> {
}
