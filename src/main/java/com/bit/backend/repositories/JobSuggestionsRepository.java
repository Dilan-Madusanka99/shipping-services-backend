package com.bit.backend.repositories;

import com.bit.backend.entities.JobSuggestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface JobSuggestionsRepository extends JpaRepository<JobSuggestionsEntity, Long> {
    Optional<JobSuggestionsEntity> findByJobIdAndSeafarerId(Long jobId, String seafarerId);


    @Query(nativeQuery = true, value = "select sf.id, job.seafarer_no, sf.surname, sf.other_names, sf.position, " +
            "sf.mobile, sf.email, sf.profile_image, job.match_score from ems.job_suggestions job\n" +
            "join ems.seafarers_registration sf\n" +
            "ON job.seafarer_id = sf.id\n" +
            "where job.job_id = :jobId")
    Optional<List<Map<String, Object>>> findJobSuggestionDetailsById(@Param("jobId") long jobId);
}
