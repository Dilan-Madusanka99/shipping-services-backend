package com.bit.backend.controllers;

import com.bit.backend.dtos.JobPostingDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.JobPostingServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class JobPostingController {

    private final JobPostingServiceI jobPostingServiceI;

    public JobPostingController(JobPostingServiceI jobPostingServiceI) {this.jobPostingServiceI = jobPostingServiceI;}

    @PostMapping("/Job_Posting")
    public ResponseEntity<JobPostingDto> addJobPosting(@RequestBody JobPostingDto jobPostingDto) {

        try {
            JobPostingDto jobPostingDtoResponse = jobPostingServiceI.addJobPostingEntity(jobPostingDto);
            return ResponseEntity.created(URI.create("/Job_Posting"+jobPostingDtoResponse.getId())).body(jobPostingDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Job_Posting")
    public ResponseEntity<List<JobPostingDto>> getData() {

        try {
            List<JobPostingDto> jobPostingDtoList = jobPostingServiceI.getData();
            return ResponseEntity.ok(jobPostingDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/Job_Posting/{id}")
    public ResponseEntity<JobPostingDto> updateJobPosting(@PathVariable Long id, @RequestBody JobPostingDto jobPostingDto) {

        try {
            JobPostingDto responseJobPostingDto = jobPostingServiceI.updateJobPosting(id, jobPostingDto);
            return ResponseEntity.ok(responseJobPostingDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/Job_Posting/{id}")
    public ResponseEntity<JobPostingDto> deleteJobPosting(@PathVariable Long id) {

        try {
            JobPostingDto jobPostingDto = jobPostingServiceI.deleteJobPosting(id);
            return ResponseEntity.ok(jobPostingDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
