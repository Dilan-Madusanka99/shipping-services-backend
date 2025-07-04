package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "certificate_Verification")
public class CertificateVerificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sid_no")
    private String sidNo;

    @Column(name = "certificate_name")
    private String certificateName;

    @Column(name = "verification_status")
    private String verificationStatus;

    @Column(name = "profile_image")  // Photo upload [start]
    private byte[] profileImage;

    @Column(name = "profile_image_name")
    private String profileImageName;

    @Column(name = "profile_image_type")
    private String profileImageType;

    public CertificateVerificationEntity() {
    }

    public CertificateVerificationEntity(Long id, String sidNo, String certificateName, String verificationStatus, byte[] profileImage, String profileImageName, String profileImageType) {
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
