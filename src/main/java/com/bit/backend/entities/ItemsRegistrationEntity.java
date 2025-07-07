package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "items_Registration")
public class ItemsRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_no")
    private String empNo;

    @Column(name = "em_no")
    private String firstName;

    @Column(name = "item_name")
    private String lastName;

    @Column(name = "item_category")
    private String callingName;

    @Column(name = "profile_image")
    private byte[] profileImage;

    @Column(name = "profile_image_name")
    private String profileImageName;

    @Column(name = "profile_image_type")
    private String profileImageType;

    public ItemsRegistrationEntity() {
    }

    public ItemsRegistrationEntity(Long id, String empNo, String firstName, String lastName, String callingName, byte[] profileImage, String profileImageName, String profileImageType) {
        this.id = id;
        this.empNo = empNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.callingName = callingName;
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

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCallingName() {
        return callingName;
    }

    public void setCallingName(String callingName) {
        this.callingName = callingName;
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
