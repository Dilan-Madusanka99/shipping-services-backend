package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CertificateVerificationDto {

    private Long id;
    private String sidNo;
    private String certificateName;
    private String verificationStatus;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] profileImage;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String profileImageName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String profileImageType;


    public CertificateVerificationDto() {
    }

    public CertificateVerificationDto(Long id, String sidNo, String certificateName, String verificationStatus, byte[] profileImage, String profileImageName, String profileImageType) {
        this.id = id;
        this.sidNo = sidNo;
        this.certificateName = certificateName;
        this.verificationStatus = verificationStatus;
        this.profileImage = profileImage;
        this.profileImageName = profileImageName;
        this.profileImageType = profileImageType;
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

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileImageName() {
        return profileImageName;
    }

    public void setProfileImageName(String profileImageName) {
        this.profileImageName = profileImageName;
    }

    public String getProfileImageType() {
        return profileImageType;
    }

    public void setProfileImageType(String profileImageType) {
        this.profileImageType = profileImageType;
    }
}
