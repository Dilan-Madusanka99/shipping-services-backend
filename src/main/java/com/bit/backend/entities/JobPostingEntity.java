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

    @Column(name = "vessel_Type")
    private String vesselType;

    @Column(name = "position")
    private String position;

    @Column(name = "c_Name")
    private String cName;

    @Column(name = "minimumExp")
    private String minimumExp;

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

    @Column(name = "job_Closing_Date")
    private String jobClosingDate;

    public JobPostingEntity() {
    }

    public JobPostingEntity(Long id, String vesselName, String vesselType, String position, String cName, String minimumExp, String jobStatus, String jobDescription, byte[] jobPostImage, String jobPostImageName, String jobPostImageType, String jobClosingDate) {
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

    public String getJobClosingDate() {
        return jobClosingDate;
    }

    public void setJobClosingDate(String jobClosingDate) {
        this.jobClosingDate = jobClosingDate;
    }
}
