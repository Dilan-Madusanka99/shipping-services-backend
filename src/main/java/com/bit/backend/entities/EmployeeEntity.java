package com.bit.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="employee")

public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "empNo")
    private String empNo;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "callingName")
    private String callingName;

    @Column(name = "nic")
    private String nic;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "roles")
    private String roles;

    @Column(name = "contactNo")
    private String contactNo;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "emergencyContactName")// emg_contact_name
    private String emergencyContactName;

    @Column(name = "emergencyContactNo") // emg_contact_no
    private String emergencyContactNo;

    @Column(name = "profile_image")  // Photo upload [start]
    private byte[] profileImage;

    @Column(name = "profile_image_name")
    private String profileImageName;

    @Column(name = "profile_image_type")
    private String profileImageType;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long id, String empNo, String firstName, String lastName, String callingName, String nic, Date dob, String roles, String contactNo, String email, String address, String emergencyContactName, String emergencyContactNo, byte[] profileImage, String profileImageName, String profileImageType) {
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
