package com.bit.backend.repositories;

import com.bit.backend.entities.JobSuggestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobSuggestionsRepository extends JpaRepository<JobSuggestionsEntity, Long> {
    Optional<JobSuggestionsEntity> findByJobIdAndSeafarerId(Long jobId, String seafarerId);
}
