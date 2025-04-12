package com.bit.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="seafarers_registration")

public class SeafarersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sidNo")
    private String sidNo;

    @Column(name = "position")
    private String position;

    @Column(name = "applied_date")
    private Date appliedDate;

    @Column(name = "available_date")
    private Date availableDate;

    @Column(name = "surname")
    private String surname;

    @Column(name = "other_names")
    private String otherNames;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "nic")
    private String nic;

    @Column(name = "religion")
    private String religion;

    @Column(name = "married_status")
    private String marriedStatus;

    @Column(name = "gender")
    private String gender;

    @Column(name = "no_of_childern")
    private String noOfChildren;

    @Column(name = "address")
    private String address;

    @Column(name = "home")
    private String home;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "kin_name")
    private String kinName;

    @Column(name = "kin_relationship")
    private String kinRelationship;

    @Column(name = "kin_address")
    private String kinAddress;

    @Column(name = "kin_mobile")
    private String kinMobile;

    @Column(name = "kin_email")
    private String kinEmail;

    @Column(name = "english_language")
    private String englishLanguage;

    public SeafarersEntity() {
    }

    public SeafarersEntity(Long id, String sidNo, String position, Date appliedDate, Date availableDate, String surname, String otherNames, Date dob, String birthPlace, String nic, String religion, String marriedStatus, String gender, String noOfChildren, String address, String home, String mobile, String email, String kinName, String kinRelationship, String kinAddress, String kinMobile, String kinEmail, String englishLanguage) {
        this.id = id;
        this.sidNo = sidNo;
        this.position = position;
        this.appliedDate = appliedDate;
        this.availableDate = availableDate;
        this.surname = surname;
        this.otherNames = otherNames;
        this.dob = dob;
        this.birthPlace = birthPlace;
        this.nic = nic;
        this.religion = religion;
        this.marriedStatus = marriedStatus;
        this.gender = gender;
        this.noOfChildren = noOfChildren;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.email = email;
        this.kinName = kinName;
        this.kinRelationship = kinRelationship;
        this.kinAddress = kinAddress;
        this.kinMobile = kinMobile;
        this.kinEmail = kinEmail;
        this.englishLanguage = englishLanguage;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getMarriedStatus() {
        return marriedStatus;
    }

    public void setMarriedStatus(String marriedStatus) {
        this.marriedStatus = marriedStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(String noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKinName() {
        return kinName;
    }

    public void setKinName(String kinName) {
        this.kinName = kinName;
    }

    public String getKinRelationship() {
        return kinRelationship;
    }

    public void setKinRelationship(String kinRelationship) {
        this.kinRelationship = kinRelationship;
    }

    public String getKinAddress() {
        return kinAddress;
    }

    public void setKinAddress(String kinAddress) {
        this.kinAddress = kinAddress;
    }

    public String getKinMobile() {
        return kinMobile;
    }

    public void setKinMobile(String kinMobile) {
        this.kinMobile = kinMobile;
    }

    public String getKinEmail() {
        return kinEmail;
    }

    public void setKinEmail(String kinEmail) {
        this.kinEmail = kinEmail;
    }

    public String getEnglishLanguage() {
        return englishLanguage;
    }

    public void setEnglishLanguage(String englishLanguage) {
        this.englishLanguage = englishLanguage;
    }
}
