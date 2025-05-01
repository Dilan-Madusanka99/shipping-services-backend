package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "User_Profile")
public class UserProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_Profile_Image")
    private byte[] userProfileImage;

    @Column(name = "user_Profile_Image_Name")
    private String userProfileImageName;

    @Column(name = "user_Profile_Image_Type")
    private String userProfileImageType;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "address")
    private String address;

    public UserProfileEntity() {
    }

    public UserProfileEntity(Long id, byte[] userProfileImage, String userProfileImageName, String userProfileImageType, String firstName, String lastName, String email, String phone, String mobile, String address) {
        this.id = id;
        this.userProfileImage = userProfileImage;
        this.userProfileImageName = userProfileImageName;
        this.userProfileImageType = userProfileImageType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(byte[] userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    public String getUserProfileImageName() {
        return userProfileImageName;
    }

    public void setUserProfileImageName(String userProfileImageName) {
        this.userProfileImageName = userProfileImageName;
    }

    public String getUserProfileImageType() {
        return userProfileImageType;
    }

    public void setUserProfileImageType(String userProfileImageType) {
        this.userProfileImageType = userProfileImageType;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
