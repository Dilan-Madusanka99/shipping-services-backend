package com.bit.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name="Other_Details_Registration")

public class OtherDetailsRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sidNo")
    private String sidNo;

    @Column(name = "sidIssuedPlace")
    private String sidIssuedPlace;

    @Column(name = "sidIssuedDate")
    private Date sidIssuedDate;

    @Column(name = "sidExpireDate")
    private Date sidExpireDate;

    @Column(name = "ppNo")
    private String ppNo;

    @Column(name = "ppIssuedPlace")
    private String ppIssuedPlace;

    @Column(name = "ppIssuedDate")
    private Date ppIssuedDate;

    @Column(name = "ppExpireDate")
    private Date ppExpireDate;

    @Column(name = "cdcNo")
    private String cdcNo;

    @Column(name = "cdcIssuedPlace")
    private String cdcIssuedPlace;

    @Column(name = "cdcIssuedDate")
    private Date cdcIssuedDate;

    @Column(name = "cdcExpireDate")
    private Date cdcExpireDate;

    @Column(name = "yellowFeverNo")
    private String yellowFeverNo;

    @Column(name = "yellowFeverIssuedPlace")
    private String yellowFeverIssuedPlace;

    @Column(name = "yellowFeverIssuedDate")
    private Date yellowFeverIssuedDate;

    @Column(name = "yellowFeverExpireDate")
    private Date yellowFeverExpireDate;

    public OtherDetailsRegistrationEntity() {
    }

    public OtherDetailsRegistrationEntity(Long id, String sidNo, String sidIssuedPlace, Date sidIssuedDate, Date sidExpireDate, String ppNo, String ppIssuedPlace, Date ppIssuedDate, Date ppExpireDate, String cdcNo, String cdcIssuedPlace, Date cdcIssuedDate, Date cdcExpireDate, String yellowFeverNo, String yellowFeverIssuedPlace, Date yellowFeverIssuedDate, Date yellowFeverExpireDate) {
        this.id = id;
        this.sidNo = sidNo;
        this.sidIssuedPlace = sidIssuedPlace;
        this.sidIssuedDate = sidIssuedDate;
        this.sidExpireDate = sidExpireDate;
        this.ppNo = ppNo;
        this.ppIssuedPlace = ppIssuedPlace;
        this.ppIssuedDate = ppIssuedDate;
        this.ppExpireDate = ppExpireDate;
        this.cdcNo = cdcNo;
        this.cdcIssuedPlace = cdcIssuedPlace;
        this.cdcIssuedDate = cdcIssuedDate;
        this.cdcExpireDate = cdcExpireDate;
        this.yellowFeverNo = yellowFeverNo;
        this.yellowFeverIssuedPlace = yellowFeverIssuedPlace;
        this.yellowFeverIssuedDate = yellowFeverIssuedDate;
        this.yellowFeverExpireDate = yellowFeverExpireDate;
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

    public String getSidIssuedPlace() {
        return sidIssuedPlace;
    }

    public void setSidIssuedPlace(String sidIssuedPlace) {
        this.sidIssuedPlace = sidIssuedPlace;
    }

    public Date getSidIssuedDate() {
        return sidIssuedDate;
    }

    public void setSidIssuedDate(Date sidIssuedDate) {
        this.sidIssuedDate = sidIssuedDate;
    }

    public Date getSidExpireDate() {
        return sidExpireDate;
    }

    public void setSidExpireDate(Date sidExpireDate) {
        this.sidExpireDate = sidExpireDate;
    }

    public String getPpNo() {
        return ppNo;
    }

    public void setPpNo(String ppNo) {
        this.ppNo = ppNo;
    }

    public String getPpIssuedPlace() {
        return ppIssuedPlace;
    }

    public void setPpIssuedPlace(String ppIssuedPlace) {
        this.ppIssuedPlace = ppIssuedPlace;
    }

    public Date getPpIssuedDate() {
        return ppIssuedDate;
    }

    public void setPpIssuedDate(Date ppIssuedDate) {
        this.ppIssuedDate = ppIssuedDate;
    }

    public Date getPpExpireDate() {
        return ppExpireDate;
    }

    public void setPpExpireDate(Date ppExpireDate) {
        this.ppExpireDate = ppExpireDate;
    }

    public String getCdcNo() {
        return cdcNo;
    }

    public void setCdcNo(String cdcNo) {
        this.cdcNo = cdcNo;
    }

    public String getCdcIssuedPlace() {
        return cdcIssuedPlace;
    }

    public void setCdcIssuedPlace(String cdcIssuedPlace) {
        this.cdcIssuedPlace = cdcIssuedPlace;
    }

    public Date getCdcIssuedDate() {
        return cdcIssuedDate;
    }

    public void setCdcIssuedDate(Date cdcIssuedDate) {
        this.cdcIssuedDate = cdcIssuedDate;
    }

    public Date getCdcExpireDate() {
        return cdcExpireDate;
    }

    public void setCdcExpireDate(Date cdcExpireDate) {
        this.cdcExpireDate = cdcExpireDate;
    }

    public String getYellowFeverNo() {
        return yellowFeverNo;
    }

    public void setYellowFeverNo(String yellowFeverNo) {
        this.yellowFeverNo = yellowFeverNo;
    }

    public String getYellowFeverIssuedPlace() {
        return yellowFeverIssuedPlace;
    }

    public void setYellowFeverIssuedPlace(String yellowFeverIssuedPlace) {
        this.yellowFeverIssuedPlace = yellowFeverIssuedPlace;
    }

    public Date getYellowFeverIssuedDate() {
        return yellowFeverIssuedDate;
    }

    public void setYellowFeverIssuedDate(Date yellowFeverIssuedDate) {
        this.yellowFeverIssuedDate = yellowFeverIssuedDate;
    }

    public Date getYellowFeverExpireDate() {
        return yellowFeverExpireDate;
    }

    public void setYellowFeverExpireDate(Date yellowFeverExpireDate) {
        this.yellowFeverExpireDate = yellowFeverExpireDate;
    }
}
