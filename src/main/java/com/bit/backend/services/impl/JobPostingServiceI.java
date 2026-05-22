package com.bit.backend.services.impl;

import com.bit.backend.dtos.JobPostingDto;

import java.util.List;

public interface JobPostingServiceI {

    JobPostingDto addJobPostingEntity(JobPostingDto jobPostingDto);
    List<JobPostingDto> getData();
    List<Integer> getAuthIds(long jobId);
    JobPostingDto updateJobPosting(long id, JobPostingDto jobPostingDto);
    JobPostingDto deleteJobPosting(long id);
    List<JobPostingDto> getOpenJobs();
}
