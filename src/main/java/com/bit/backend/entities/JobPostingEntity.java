package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Job_Posting")
public class JobPostingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_Post")
    private String jobPost;

    @Column(name = "job_Description")
    private String jobDescription;

    @Column(name = "job_PostingDate")
    private String jobPostingDate;

    @Column(name = "job_Post_Image")
    private byte[] jobPostImage;

    @Column(name = "jobPost_Image_Name")
    private String jobPostImageName;

    @Column(name = "jobPost_Image_Type")
    private String jobPostImageType;

    public JobPostingEntity() {
    }

    public JobPostingEntity(Long id, String jobPost, String jobDescription, String jobPostingDate, byte[] jobPostImage, String jobPostImageName, String jobPostImageType) {
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
