package com.bit.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Certificates_Registration")
public class CertificatesRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sidNo")
    private String sidNo;

    @Column(name = "cName")
    private String cName;

    @Column(name = "cNo")
    private String cNo;

    @Column(name = "cIssuedPlace")
    private String cIssuedPlace;

    @Column(name = "cIssuedDate")
    private Date cIssuedDate;

    @Column(name = "cExpiredDate")
    private Date cExpiredDate;

    @Column(name = "verificationStatus")
    private String verificationStatus;

    public CertificatesRegistrationEntity() {
    }

    public CertificatesRegistrationEntity(String cIssuedPlace, Long id, String sidNo, String cName, String cNo, Date cIssuedDate, Date cExpiredDate, String verificationStatus) {
        this.cIssuedPlace = cIssuedPlace;
        this.id = id;
        this.sidNo = sidNo;
        this.cName = cName;
        this.cNo = cNo;
        this.cIssuedDate = cIssuedDate;
        this.cExpiredDate = cExpiredDate;
        this.verificationStatus = verificationStatus;
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

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }
}
