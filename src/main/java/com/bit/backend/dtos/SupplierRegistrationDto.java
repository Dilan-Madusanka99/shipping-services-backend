package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SupplierRegistrationDto {

    private Long id;
    private String supplierNo;
    private String supplierName;
    private String supplierCategory;
    private String supplierSubCategory;
    private String supplierContactNo;
    private String supplierEmail;
    private String supplierAccName;
    private String supplierAccNo;
    private String supplierBank;
    private String supplierBranch;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] profileImage;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String profileImageName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String profileImageType;

    public SupplierRegistrationDto() {
    }

    public SupplierRegistrationDto(Long id, String supplierNo, String supplierName, String supplierCategory, String supplierSubCategory, String supplierContactNo, String supplierEmail, String supplierAccName, String supplierAccNo, String supplierBank, String supplierBranch, byte[] profileImage, String profileImageName, String profileImageType) {
        this.id = id;
        this.supplierNo = supplierNo;
        this.supplierName = supplierName;
        this.supplierCategory = supplierCategory;
        this.supplierSubCategory = supplierSubCategory;
        this.supplierContactNo = supplierContactNo;
        this.supplierEmail = supplierEmail;
        this.supplierAccName = supplierAccName;
        this.supplierAccNo = supplierAccNo;
        this.supplierBank = supplierBank;
        this.supplierBranch = supplierBranch;
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

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierCategory() {
        return supplierCategory;
    }

    public void setSupplierCategory(String supplierCategory) {
        this.supplierCategory = supplierCategory;
    }

    public String getSupplierSubCategory() {
        return supplierSubCategory;
    }

    public void setSupplierSubCategory(String supplierSubCategory) {
        this.supplierSubCategory = supplierSubCategory;
    }

    public String getSupplierContactNo() {
        return supplierContactNo;
    }

    public void setSupplierContactNo(String supplierContactNo) {
        this.supplierContactNo = supplierContactNo;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierAccName() {
        return supplierAccName;
    }

    public void setSupplierAccName(String supplierAccName) {
        this.supplierAccName = supplierAccName;
    }

    public String getSupplierAccNo() {
        return supplierAccNo;
    }

    public void setSupplierAccNo(String supplierAccNo) {
        this.supplierAccNo = supplierAccNo;
    }

    public String getSupplierBank() {
        return supplierBank;
    }

    public void setSupplierBank(String supplierBank) {
        this.supplierBank = supplierBank;
    }

    public String getSupplierBranch() {
        return supplierBranch;
    }

    public void setSupplierBranch(String supplierBranch) {
        this.supplierBranch = supplierBranch;
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
