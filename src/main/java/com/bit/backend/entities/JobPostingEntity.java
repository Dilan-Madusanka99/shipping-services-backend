package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Job_Posting")
public class JobPostingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vessel_name")
    private String vesselName;

    @Column(name = "position")
    private String position;

    @Column(name = "job_status")
    private String jobStatus;

    @Column(name = "job_Description")
    private String jobDescription;

    @Column(name = "job_Post_Image")
    private byte[] jobPostImage;

    @Column(name = "jobPost_Image_Name")
    private String jobPostImageName;

    @Column(name = "jobPost_Image_Type")
    private String jobPostImageType;

    public JobPostingEntity() {
    }

    public JobPostingEntity(Long id, String vesselName, String position, String jobStatus, String jobDescription, byte[] jobPostImage, String jobPostImageName, String jobPostImageType) {
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
