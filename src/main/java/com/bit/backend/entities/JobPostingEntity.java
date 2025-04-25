package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Job_Posting")
public class JobPostingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jobPost")
    private String jobPost;

    @Column(name = "jobDescription")
    private String jobDescription;

    @Column(name = "jobPostingDate")
    private String jobPostingDate;

    public JobPostingEntity() {
    }

    public JobPostingEntity(Long id, String jobPost, String jobDescription, String jobPostingDate) {
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
