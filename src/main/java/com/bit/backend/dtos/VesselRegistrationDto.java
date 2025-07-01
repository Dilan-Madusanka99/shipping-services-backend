package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VesselRegistrationDto {

    private Long id;
    private String vesselName;
    private String imoNo;
    private String vesselType;
    private String flag;
    private String yob;
    private String grt;
    private String bhp;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] profileImage;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String profileImageName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String profileImageType;

    public VesselRegistrationDto() {
    }

    public VesselRegistrationDto(Long id, String vesselName, String imoNo, String vesselType, String flag, String yob, String grt, String bhp, byte[] profileImage, String profileImageName, String profileImageType) {
        this.id = id;
        this.vesselName = vesselName;
        this.imoNo = imoNo;
        this.vesselType = vesselType;
        this.flag = flag;
        this.yob = yob;
        this.grt = grt;
        this.bhp = bhp;
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
