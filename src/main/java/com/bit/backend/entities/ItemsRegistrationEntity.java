package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "items_Registration")
public class ItemsRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_no")
    private String itemNo;

    @Column(name = "em_no")
    private String emNo;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_category")
    private String itemCategory;

    @Column(name = "profile_image")
    private byte[] profileImage;

    @Column(name = "profile_image_name")
    private String profileImageName;

    @Column(name = "profile_image_type")
    private String profileImageType;

    public ItemsRegistrationEntity() {
    }

    public ItemsRegistrationEntity(Long id, String itemNo, String emNo, String itemName, String itemCategory, byte[] profileImage, String profileImageName, String profileImageType) {
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
