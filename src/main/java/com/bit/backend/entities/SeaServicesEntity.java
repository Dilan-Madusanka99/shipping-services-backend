package com.bit.backend.entities;


import jakarta.persistence.*;

@Entity
@Table(name="Sea_Services")
public class SeaServicesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sidNo")
    private String sidNo;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "vesselName")
    private String vesselName;

    @Column(name = "position")
    private String position;

    @Column(name = "vesselType")
    private String vesselType;

    @Column(name = "flag")
    private String flag;

    @Column(name = "grt")
    private String grt;

    @Column(name = "bhp")
    private String bhp;

    @Column(name = "signOn")
    private String signOn;

    @Column(name = "signOff")
    private String signOff;

    @Column(name = "totalMonths")
    private String totalMonths;

    @Column(name = "reason")
    private String reason;

    public SeaServicesEntity() {
    }

    public SeaServicesEntity(Long id, String sidNo, String companyName, String vesselName, String position, String vesselType, String flag, String grt, String bhp, String signOn, String signOff, String totalMonths, String reason) {
        this.id = id;
        this.sidNo = sidNo;
        this.companyName = companyName;
        this.vesselName = vesselName;
        this.position = position;
        this.vesselType = vesselType;
        this.flag = flag;
        this.grt = grt;
        this.bhp = bhp;
        this.signOn = signOn;
        this.signOff = signOff;
        this.totalMonths = totalMonths;
        this.reason = reason;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getGrt() {
        return grt;
    }

    public void setGrt(String grt) {
        this.grt = grt;
    }

    public String getBhp() {
        return bhp;
    }

    public void setBhp(String bhp) {
        this.bhp = bhp;
    }

    public String getSignOn() {
        return signOn;
    }

    public void setSignOn(String signOn) {
        this.signOn = signOn;
    }

    public String getSignOff() {
        return signOff;
    }

    public void setSignOff(String signOff) {
        this.signOff = signOff;
    }

    public String getTotalMonths() {
        return totalMonths;
    }

    public void setTotalMonths(String totalMonths) {
        this.totalMonths = totalMonths;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
