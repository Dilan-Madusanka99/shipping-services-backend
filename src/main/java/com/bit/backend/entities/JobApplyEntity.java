package com.bit.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Job_Apply")
public class JobApplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vessel_name")
    private String vesselName;

    @Column(name = "vessel_Type")
    private String vesselType;

    @Column(name = "position")
    private String position;

    @Column(name = "status")
    private String status;

    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "seafarer_id")
    private Long seafarerId;

    @Column(name = "seafarer_name")
    private String seafarerName;

    @Column(name = "applied_date")
    private Date appliedDate;

    @Column(name = "job_close_date")
    private Date jobCloseDate;

    public JobApplyEntity() {
    }

    public JobApplyEntity(Long id, String vesselName, String vesselType, String position, String status, Long jobId, Long seafarerId, String seafarerName, Date appliedDate, Date jobCloseDate) {
        this.id = id;
        this.vesselName = vesselName;
        this.vesselType = vesselType;
        this.position = position;
        this.status = status;
        this.jobId = jobId;
        this.seafarerId = seafarerId;
        this.seafarerName = seafarerName;
        this.appliedDate = appliedDate;
        this.jobCloseDate = jobCloseDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getSeafarerId() {
        return seafarerId;
    }

    public void setSeafarerId(Long seafarerId) {
        this.seafarerId = seafarerId;
    }

    public String getSeafarerName() {
        return seafarerName;
    }

    public void setSeafarerName(String seafarerName) {
        this.seafarerName = seafarerName;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public Date getJobCloseDate() {
        return jobCloseDate;
    }

    public void setJobCloseDate(Date jobCloseDate) {
        this.jobCloseDate = jobCloseDate;
    }
}
