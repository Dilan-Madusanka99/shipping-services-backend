package com.bit.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "crew_complaints")
public class CrewComplaintsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sid_no")
    private String sidNo;

    @Column(name = "imo_no")
    private String imoNo;

    @Column(name = "vessel_name")
    private String vesselName;

    @Column(name = "complaintor_name")
    private String complaintorName;

    @Column(name = "complaint_date")
    private Date complaintDate;

    @Column(name = "complaint_type")
    private String complaintType;

    @Column(name = "complaint")
    private String complaint;

    public CrewComplaintsEntity() {
    }

    public CrewComplaintsEntity(Long id, String sidNo, String imoNo, String vesselName, String complaintorName, Date complaintDate, String complaintType, String complaint) {
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
