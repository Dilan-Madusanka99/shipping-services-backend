package com.bit.backend.dtos;

import java.util.Date;

public class CrewComplaintsDto {

    private Long id;
    private String sidNo;
    private String imoNo;
    private String vesselName;
    private String complaintorName;
    private Date complaintDate;
    private String complaintType;
    private String complaint;

    public CrewComplaintsDto() {
    }

    public CrewComplaintsDto(Long id, String sidNo, String imoNo, String vesselName, String complaintorName, Date complaintDate, String complaintType, String complaint) {
        this.id = id;
        this.sidNo = sidNo;
        this.imoNo = imoNo;
        this.vesselName = vesselName;
        this.complaintorName = complaintorName;
        this.complaintDate = complaintDate;
        this.complaintType = complaintType;
        this.complaint = complaint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSidNo() {
        return sidNo;
    }

    public void setSidNo(String sidNo) {
        this.sidNo = sidNo;
    }

    public String getImoNo() {
        return imoNo;
    }

    public void setImoNo(String imoNo) {
        this.imoNo = imoNo;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getComplaintorName() {
        return complaintorName;
    }

    public void setComplaintorName(String complaintorName) {
        this.complaintorName = complaintorName;
    }

    public Date getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
