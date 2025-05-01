package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobPostingDto {

    private Long id;
    private String jobPost;
    private String jobDescription;
    private String jobPostingDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] jobPostImage;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String jobPostImageName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String jobPostImageType;

    public JobPostingDto() {
    }

    public JobPostingDto(Long id, String jobPost, String jobDescription, String jobPostingDate, byte[] jobPostImage, String jobPostImageName, String jobPostImageType) {
        this.id = id;
        this.jobPost = jobPost;
        this.jobDescription = jobDescription;
        this.jobPostingDate = jobPostingDate;
        this.jobPostImage = jobPostImage;
        this.jobPostImageName = jobPostImageName;
        this.jobPostImageType = jobPostImageType;
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

    public byte[] getJobPostImage() {
        return jobPostImage;
    }

    public void setJobPostImage(byte[] jobPostImage) {
        this.jobPostImage = jobPostImage;
    }

    public String getJobPostImageName() {
        return jobPostImageName;
    }

    public void setJobPostImageName(String jobPostImageName) {
        this.jobPostImageName = jobPostImageName;
    }

    public String getJobPostImageType() {
        return jobPostImageType;
    }

    public void setJobPostImageType(String jobPostImageType) {
        this.jobPostImageType = jobPostImageType;
    }
}
