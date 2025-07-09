package com.bit.backend.controllers;

import com.bit.backend.dtos.JobPostingDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.JobPostingServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
public class JobPostingController {

    private final JobPostingServiceI jobPostingServiceI;

    public JobPostingController(JobPostingServiceI jobPostingServiceI) {this.jobPostingServiceI = jobPostingServiceI;}

    @PostMapping(value = {"/job_posting"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<JobPostingDto> addJobPosting(@RequestPart("jobPostingForm") JobPostingDto jobPostingDto,
                                                       @RequestPart("jobPostImage") MultipartFile file) {

        try {
            jobPostingDto.setJobPostImage(file.getBytes());
            jobPostingDto.setJobPostImageName(file.getOriginalFilename());
            jobPostingDto.setJobPostImageType(file.getContentType());
            JobPostingDto jobPostingDtoResponse = jobPostingServiceI.addJobPostingEntity(jobPostingDto);
            return ResponseEntity.created(URI.create("/job_posting"+jobPostingDtoResponse.getId())).body(jobPostingDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/job_posting")
    public ResponseEntity<List<JobPostingDto>> getData() {

        try {
            List<JobPostingDto> jobPostingDtoList = jobPostingServiceI.getData();
            return ResponseEntity.ok(jobPostingDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/job_posting/{id}")
    public ResponseEntity<JobPostingDto> updateJobPosting(@PathVariable Long id,
                                                      @RequestPart ("jobPostingForm") JobPostingDto jobPostingDto,
                                                      @RequestPart(value = "jobPostImage", required = false) MultipartFile file) {

        try {
            if (file != null && !file.isEmpty()) {
                jobPostingDto.setJobPostImage(file.getBytes());
                jobPostingDto.setJobPostImageName(file.getOriginalFilename());
                jobPostingDto.setJobPostImageType(file.getContentType());
            }
            JobPostingDto responseJobPostingDto = jobPostingServiceI.updateJobPosting(id, jobPostingDto);
            return ResponseEntity.ok(responseJobPostingDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/job_posting/{id}")
    public ResponseEntity<JobPostingDto> deleteJobPosting(@PathVariable Long id) {

        try {
            JobPostingDto jobPostingDto = jobPostingServiceI.deleteJobPosting(id);
            return ResponseEntity.ok(jobPostingDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
