package com.bit.backend.dtos;

import java.util.Date;

public class SeaServicesDto {

    private Long id;
    private String sidNo;
    private String companyName;
    private String vesselName;
    private String position;
    private String vesselType;
    private String flag;
    private String grt;
    private String bhp;
    private Date signOn;
    private Date signOff;
    private String totalMonths;
    private String reason;

    public SeaServicesDto() {
    }

    public SeaServicesDto(Long id, String sidNo, String companyName, String vesselName, String position, String vesselType, String flag, String grt, String bhp, Date signOn, Date signOff, String totalMonths, String reason) {
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

    public Date getSignOn() {
        return signOn;
    }

    public void setSignOn(Date signOn) {
        this.signOn = signOn;
    }

    public Date getSignOff() {
        return signOff;
    }

    public void setSignOff(Date signOff) {
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
