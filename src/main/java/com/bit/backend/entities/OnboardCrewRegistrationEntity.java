package com.bit.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "onboard_crew_registration")
public class OnboardCrewRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sidNo")
    private String sidNo;

    @Column(name = "position")
    private String position;

    @Column(name = "imoNo")
    private String imoNo;

    @Column(name = "vesselName")
    private String vesselName   ;

    @Column(name = "signOnDate")
    private Date signOnDate;

    @Column(name = "signOffDate")
    private Date signOffDate;

    public OnboardCrewRegistrationEntity() {
    }

    public OnboardCrewRegistrationEntity(Long id, String sidNo, String position, String imoNo, String vesselName, Date signOnDate, Date signOffDate) {
        this.id = id;
        this.sidNo = sidNo;
        this.position = position;
        this.imoNo = imoNo;
        this.vesselName = vesselName;
        this.signOnDate = signOnDate;
        this.signOffDate = signOffDate;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public Date getSignOnDate() {
        return signOnDate;
    }

    public void setSignOnDate(Date signOnDate) {
        this.signOnDate = signOnDate;
    }

    public Date getSignOffDate() {
        return signOffDate;
    }

    public void setSignOffDate(Date signOffDate) {
        this.signOffDate = signOffDate;
    }
}
