package com.bit.backend.entities;

import jakarta.persistence.*;

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

    public JobApplyEntity() {
    }

    public JobApplyEntity(Long id, String vesselName, String vesselType, String position, String status, Long jobId, Long seafarerId, String seafarerName) {
        this.id = id;
        this.vesselName = vesselName;
        this.vesselType = vesselType;
        this.position = position;
        this.status = status;
        this.jobId = jobId;
        this.seafarerId = seafarerId;
        this.seafarerName = seafarerName;
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
}
