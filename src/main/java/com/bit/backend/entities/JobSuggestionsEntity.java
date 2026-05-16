package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Job_Suggestions")
public class JobSuggestionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "seafarer_id")
    private String seafarerId;

    @Column(name = "seafarer_no")
    private String seafarerNo;

    @Column(name = "match_score")
    private float matchScore;

    @Column(name = "status")
    private String status;

    @Column(name = "vessle_name")
    private String vessleName;

    @Column(name = "position")
    private String position;

    public JobSuggestionsEntity() {
    }

    public JobSuggestionsEntity(Long id, Long jobId, String jobName, String seafarerId, String seafarerNo, float matchScore, String status, String vessleName, String position) {
        this.id = id;
        this.jobId = jobId;
        this.jobName = jobName;
        this.seafarerId = seafarerId;
        this.seafarerNo = seafarerNo;
        this.matchScore = matchScore;
        this.status = status;
        this.vessleName = vessleName;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getSeafarerId() {
        return seafarerId;
    }

    public void setSeafarerId(String seafarerId) {
        this.seafarerId = seafarerId;
    }

    public String getSeafarerNo() {
        return seafarerNo;
    }

    public void setSeafarerNo(String seafarerNo) {
        this.seafarerNo = seafarerNo;
    }

    public float getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(float matchScore) {
        this.matchScore = matchScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVessleName() {
        return vessleName;
    }

    public void setVessleName(String vessleName) {
        this.vessleName = vessleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
