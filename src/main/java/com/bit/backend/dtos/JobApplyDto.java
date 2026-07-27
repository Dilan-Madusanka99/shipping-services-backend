package com.bit.backend.dtos;

import java.util.Date;

public class JobApplyDto {

    private Long id;
    private Long jobId;
    private Long seafarerId;
    private String seafarerName;
    private String vesselName;
    private String vesselType;
    private String position;
    private  String status;
    private Date appliedDate;
    private Date jobCloseDate;

    public JobApplyDto() {
    }

    public JobApplyDto(Long id, Long jobId, Long seafarerId, String seafarerName, String vesselName, String vesselType, String position, String status, Date appliedDate, Date jobCloseDate) {
        this.id = id;
        this.jobId = jobId;
        this.seafarerId = seafarerId;
        this.seafarerName = seafarerName;
        this.vesselName = vesselName;
        this.vesselType = vesselType;
        this.position = position;
        this.status = status;
        this.appliedDate = appliedDate;
        this.jobCloseDate = jobCloseDate;
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
