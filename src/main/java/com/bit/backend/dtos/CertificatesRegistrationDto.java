package com.bit.backend.dtos;

import java.util.Date;

public class CertificatesRegistrationDto {

    private Long id;
    private String sidNo;
    private String cName;
    private String cNo;
    private String cIssuedPlace;
    private Date cIssuedDate;
    private Date cExpiredDate;

    public CertificatesRegistrationDto() {
    }

    public CertificatesRegistrationDto(Long id, String sidNo, String cName, String cNo, String cIssuedPlace, Date cIssuedDate, Date cExpiredDate) {
        this.id = id;
        this.sidNo = sidNo;
        this.cName = cName;
        this.cNo = cNo;
        this.cIssuedPlace = cIssuedPlace;
        this.cIssuedDate = cIssuedDate;
        this.cExpiredDate = cExpiredDate;
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

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcNo() {
        return cNo;
    }

    public void setcNo(String cNo) {
        this.cNo = cNo;
    }

    public String getcIssuedPlace() {
        return cIssuedPlace;
    }

    public void setcIssuedPlace(String cIssuedPlace) {
        this.cIssuedPlace = cIssuedPlace;
    }

    public Date getcIssuedDate() {
        return cIssuedDate;
    }

    public void setcIssuedDate(Date cIssuedDate) {
        this.cIssuedDate = cIssuedDate;
    }

    public Date getcExpiredDate() {
        return cExpiredDate;
    }

    public void setcExpiredDate(Date cExpiredDate) {
        this.cExpiredDate = cExpiredDate;
    }
}
