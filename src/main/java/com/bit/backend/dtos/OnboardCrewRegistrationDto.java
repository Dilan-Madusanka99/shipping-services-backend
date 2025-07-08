package com.bit.backend.dtos;

import java.util.Date;

public class OnboardCrewRegistrationDto {

    private Long id;
    private String sidNo;
    private String position;
    private String imoNo;
    private String vesselName;
    private Date signOnDate;
    private Date signOffDate;

    public OnboardCrewRegistrationDto() {
    }

    public OnboardCrewRegistrationDto(Long id, String sidNo, String position, String imoNo, String vesselName, Date signOnDate, Date signOffDate) {
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
