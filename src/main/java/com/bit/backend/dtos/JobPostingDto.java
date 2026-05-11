package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class JobPostingDto {

    private Long id;
    private String vesselName;
    private String vesselType;
    private String position;
    private String cName;
    private String minimumExp;
    private  String jobStatus;
    private String jobDescription;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] jobPostImage;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String jobPostImageName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String jobPostImageType;
    private Date jobClosingDate;

    public JobPostingDto() {
    }

    public JobPostingDto(Long id, String vesselName, String vesselType, String position, String cName, String minimumExp, String jobStatus, String jobDescription, byte[] jobPostImage, String jobPostImageName, String jobPostImageType, Date jobClosingDate) {
        this.id = id;
        this.vesselName = vesselName;
        this.vesselType = vesselType;
        this.position = position;
        this.cName = cName;
        this.minimumExp = minimumExp;
        this.jobStatus = jobStatus;
        this.jobDescription = jobDescription;
        this.jobPostImage = jobPostImage;
        this.jobPostImageName = jobPostImageName;
        this.jobPostImageType = jobPostImageType;
        this.jobClosingDate = jobClosingDate;
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

    public String getVesselType() {
        return vesselType;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getMinimumExp() {
        return minimumExp;
    }

    public void setMinimumExp(String minimumExp) {
        this.minimumExp = minimumExp;
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

    public Date getJobClosingDate() {
        return jobClosingDate;
    }

    public void setJobClosingDate(Date jobClosingDate) {
        this.jobClosingDate = jobClosingDate;
    }
}
