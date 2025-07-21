package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CertificatesRegistrationDto {

    private Long id;
    private String sidNo;
    private String cName;
    private String cNo;
    private String cIssuedPlace;
    private Date cIssuedDate;
    private Date cExpiredDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] certificateImage;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String certificateImageName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String certificateImageType;

    public CertificatesRegistrationDto() {
    }

    public CertificatesRegistrationDto(Long id, String sidNo, String cName, String cNo, String cIssuedPlace, Date cIssuedDate, Date cExpiredDate, byte[] certificateImage, String certificateImageName, String certificateImageType) {
        this.id = id;
        this.sidNo = sidNo;
        this.cName = cName;
        this.cNo = cNo;
        this.cIssuedPlace = cIssuedPlace;
        this.cIssuedDate = cIssuedDate;
        this.cExpiredDate = cExpiredDate;
        this.certificateImage = certificateImage;
        this.certificateImageName = certificateImageName;
        this.certificateImageType = certificateImageType;
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

    public byte[] getCertificateImage() {
        return certificateImage;
    }

    public void setCertificateImage(byte[] certificateImage) {
        this.certificateImage = certificateImage;
    }

    public String getCertificateImageName() {
        return certificateImageName;
    }

    public void setCertificateImageName(String certificateImageName) {
        this.certificateImageName = certificateImageName;
    }

    public String getCertificateImageType() {
        return certificateImageType;
    }

    public void setCertificateImageType(String certificateImageType) {
        this.certificateImageType = certificateImageType;
    }
}
