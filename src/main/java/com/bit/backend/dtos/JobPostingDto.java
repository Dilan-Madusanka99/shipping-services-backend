package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobPostingDto {

    private Long id;
    private String vesselName;
    private String position;
    private  String jobStatus;
    private String jobDescription;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] jobPostImage;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String jobPostImageName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String jobPostImageType;

    public JobPostingDto() {
    }

    public JobPostingDto(Long id, String vesselName, String position, String jobStatus, String jobDescription, byte[] jobPostImage, String jobPostImageName, String jobPostImageType) {
        this.id = id;
        this.vesselName = vesselName;
        this.position = position;
        this.jobStatus = jobStatus;
        this.jobDescription = jobDescription;
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

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
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
