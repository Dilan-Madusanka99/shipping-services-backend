package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class EmployeeDto {

    private Long id;
    private String empNo;
    private String firstName;
    private String lastName;
    private String callingName;
    private String nic;
    private Date dob;
    private String roles;
    private String contactNo;
    private String email;
    private String address;
    private String emergencyContactName;
    private String emergencyContactNo;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] profileImage;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String profileImageName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String profileImageType;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String empNo, String firstName, String lastName, String callingName, String nic, Date dob, String roles, String contactNo, String email, String address, String emergencyContactName, String emergencyContactNo, byte[] profileImage, String profileImageName, String profileImageType) {
        this.id = id;
        this.empNo = empNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.callingName = callingName;
        this.nic = nic;
        this.dob = dob;
        this.roles = roles;
        this.contactNo = contactNo;
        this.email = email;
        this.address = address;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactNo = emergencyContactNo;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactNo() {
        return emergencyContactNo;
    }

    public void setEmergencyContactNo(String emergencyContactNo) {
        this.emergencyContactNo = emergencyContactNo;
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
