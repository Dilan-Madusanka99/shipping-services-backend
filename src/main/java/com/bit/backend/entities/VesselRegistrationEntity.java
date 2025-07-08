package com.bit.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "vessel_registration")
public class VesselRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vessel_Name")
    private String vesselName;

    @Column(name = "imo_No")
    private String imoNo;

    @Column(name = "vessel_Type")
    private String vesselType;

    @Column(name = "flag")
    private String flag;

    @Column(name = "yob")
    private String yob;

    @Column(name = "grt")
    private Date grt;

    @Column(name = "bhp")
    private String bhp;

    @Column(name = "roles")
    private String roles;

    @Column(name = "profile_image")  // Photo upload [start]
    private byte[] profileImage;

    @Column(name = "profile_image_name")
    private String profileImageName;

    @Column(name = "profile_image_type")
    private String profileImageType;

    public VesselRegistrationEntity() {
    }

    public VesselRegistrationEntity(Long id, String vesselName, String imoNo, String vesselType, String flag, String yob, Date grt, String bhp, String roles, byte[] profileImage, String profileImageName, String profileImageType) {
        this.id = id;
        this.vesselName = vesselName;
        this.imoNo = imoNo;
        this.vesselType = vesselType;
        this.flag = flag;
        this.yob = yob;
        this.grt = grt;
        this.bhp = bhp;
        this.roles = roles;
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

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getImoNo() {
        return imoNo;
    }

    public void setImoNo(String imoNo) {
        this.imoNo = imoNo;
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

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    public Date getGrt() {
        return grt;
    }

    public void setGrt(Date grt) {
        this.grt = grt;
    }

    public String getBhp() {
        return bhp;
    }

    public void setBhp(String bhp) {
        this.bhp = bhp;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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
