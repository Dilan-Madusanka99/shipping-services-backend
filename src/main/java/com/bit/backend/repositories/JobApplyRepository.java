package com.bit.backend.repositories;

import com.bit.backend.entities.JobApplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobApplyRepository extends JpaRepository<JobApplyEntity, Long> {
    Optional<JobApplyEntity> findByJobIdAndSeafarerId(Long jobId, Long seafarerId);

    @Query(nativeQuery = true, value = "SELECT * FROM job_apply WHERE seafarer_id = :seafarerId order by applied_date desc")
    List<JobApplyEntity> getJobAppliedDetailsBySeafarerId(@Param("seafarerId") Long seafarerId);
}
