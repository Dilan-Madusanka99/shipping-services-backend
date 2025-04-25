package com.bit.backend.dtos;

public class JobPostingDto {

    private Long id;
    private String jobPost;
    private String jobDescription;
    private String jobPostingDate;

    public JobPostingDto() {
    }

    public JobPostingDto(Long id, String jobPost, String jobDescription, String jobPostingDate) {
        this.id = id;
        this.jobPost = jobPost;
        this.jobDescription = jobDescription;
        this.jobPostingDate = jobPostingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobPost() {
        return jobPost;
    }

    public void setJobPost(String jobPost) {
        this.jobPost = jobPost;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobPostingDate() {
        return jobPostingDate;
    }

    public void setJobPostingDate(String jobPostingDate) {
        this.jobPostingDate = jobPostingDate;
    }
}
