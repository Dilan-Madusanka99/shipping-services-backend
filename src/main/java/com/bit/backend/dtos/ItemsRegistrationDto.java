package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemsRegistrationDto {

    private Long id;
    private String itemNo;
    private String emNo;
    private String itemName;
    private String itemCategory;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] profileImage;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String profileImageName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String profileImageType;

    public ItemsRegistrationDto() {
    }

    public ItemsRegistrationDto(Long id, String itemNo, String emNo, String itemName, String itemCategory, byte[] profileImage, String profileImageName, String profileImageType) {
        this.id = id;
        this.itemNo = itemNo;
        this.emNo = emNo;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
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

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getEmNo() {
        return emNo;
    }

    public void setEmNo(String emNo) {
        this.emNo = emNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
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
