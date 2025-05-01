package com.bit.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name="Other_Details_Registration")

public class OtherDetailsRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sid_Image")
    private byte[] sidImage;

    @Column(name = "sid_Image_Name")
    private String sidImageName;

    @Column(name = "sid_Image_Type")
    private String sidImageType;

    @Column(name = "sid_No")
    private String sidNo;

    @Column(name = "sid_Issued_Place")
    private String sidIssuedPlace;

    @Column(name = "sid_Issued_Date")
    private Date sidIssuedDate;

    @Column(name = "sid_Expire_Date")
    private Date sidExpireDate;

    @Column(name = "pp_Image")
    private byte[] ppImage;

    @Column(name = "pp_Image_Name")
    private String ppImageName;

    @Column(name = "pp_Image_Type")
    private String ppImageType;

    @Column(name = "pp_No")
    private String ppNo;

    @Column(name = "pp_Issued_Place")
    private String ppIssuedPlace;

    @Column(name = "pp_Issued_Date")
    private Date ppIssuedDate;

    @Column(name = "pp_Expire_Date")
    private Date ppExpireDate;

    @Column(name = "cdc_Image")
    private byte[] cdcImage;

    @Column(name = "cdc_Image_Name")
    private String cdcImageName;

    @Column(name = "cdc_Image_Type")
    private String cdcImageType;

    @Column(name = "cdc_No")
    private String cdcNo;

    @Column(name = "cdc_Issued_Place")
    private String cdcIssuedPlace;

    @Column(name = "cdc_Issued_Date")
    private Date cdcIssuedDate;

    @Column(name = "cdc_Expire_Date")
    private Date cdcExpireDate;

    @Column(name = "yellow_Fever_Image")
    private byte[] yellowFeverImage;

    @Column(name = "yellow_Fever_Image_Name")
    private String yellowFeverImageName;

    @Column(name = "yellow_Fever_Image_Type")
    private String jobPostImageType;

    @Column(name = "yellow_Fever_No")
    private String yellowFeverNo;

    @Column(name = "yellow_Fever_Issued_Place")
    private String yellowFeverIssuedPlace;

    @Column(name = "yellow_Fever_Issued_Date")
    private Date yellowFeverIssuedDate;

    @Column(name = "yellow_Fever_Expire_Date")
    private Date yellowFeverExpireDate;

    public OtherDetailsRegistrationEntity() {
    }

    public OtherDetailsRegistrationEntity(Long id, byte[] sidImage, String sidImageName, String sidImageType, String sidNo, String sidIssuedPlace, Date sidIssuedDate, Date sidExpireDate, byte[] ppImage, String ppImageName, String ppImageType, String ppNo, String ppIssuedPlace, Date ppIssuedDate, Date ppExpireDate, byte[] cdcImage, String cdcImageName, String cdcImageType, String cdcNo, String cdcIssuedPlace, Date cdcIssuedDate, Date cdcExpireDate, byte[] yellowFeverImage, String yellowFeverImageName, String jobPostImageType, String yellowFeverNo, String yellowFeverIssuedPlace, Date yellowFeverIssuedDate, Date yellowFeverExpireDate) {
        this.id = id;
        this.sidImage = sidImage;
        this.sidImageName = sidImageName;
        this.sidImageType = sidImageType;
        this.sidNo = sidNo;
        this.sidIssuedPlace = sidIssuedPlace;
        this.sidIssuedDate = sidIssuedDate;
        this.sidExpireDate = sidExpireDate;
        this.ppImage = ppImage;
        this.ppImageName = ppImageName;
        this.ppImageType = ppImageType;
        this.ppNo = ppNo;
        this.ppIssuedPlace = ppIssuedPlace;
        this.ppIssuedDate = ppIssuedDate;
        this.ppExpireDate = ppExpireDate;
        this.cdcImage = cdcImage;
        this.cdcImageName = cdcImageName;
        this.cdcImageType = cdcImageType;
        this.cdcNo = cdcNo;
        this.cdcIssuedPlace = cdcIssuedPlace;
        this.cdcIssuedDate = cdcIssuedDate;
        this.cdcExpireDate = cdcExpireDate;
        this.yellowFeverImage = yellowFeverImage;
        this.yellowFeverImageName = yellowFeverImageName;
        this.jobPostImageType = jobPostImageType;
        this.yellowFeverNo = yellowFeverNo;
        this.yellowFeverIssuedPlace = yellowFeverIssuedPlace;
        this.yellowFeverIssuedDate = yellowFeverIssuedDate;
        this.yellowFeverExpireDate = yellowFeverExpireDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getSidImage() {
        return sidImage;
    }

    public void setSidImage(byte[] sidImage) {
        this.sidImage = sidImage;
    }

    public String getSidImageName() {
        return sidImageName;
    }

    public void setSidImageName(String sidImageName) {
        this.sidImageName = sidImageName;
    }

    public String getSidImageType() {
        return sidImageType;
    }

    public void setSidImageType(String sidImageType) {
        this.sidImageType = sidImageType;
    }

    public String getSidNo() {
        return sidNo;
    }

    public void setSidNo(String sidNo) {
        this.sidNo = sidNo;
    }

    public String getSidIssuedPlace() {
        return sidIssuedPlace;
    }

    public void setSidIssuedPlace(String sidIssuedPlace) {
        this.sidIssuedPlace = sidIssuedPlace;
    }

    public Date getSidIssuedDate() {
        return sidIssuedDate;
    }

    public void setSidIssuedDate(Date sidIssuedDate) {
        this.sidIssuedDate = sidIssuedDate;
    }

    public Date getSidExpireDate() {
        return sidExpireDate;
    }

    public void setSidExpireDate(Date sidExpireDate) {
        this.sidExpireDate = sidExpireDate;
    }

    public byte[] getPpImage() {
        return ppImage;
    }

    public void setPpImage(byte[] ppImage) {
        this.ppImage = ppImage;
    }

    public String getPpImageName() {
        return ppImageName;
    }

    public void setPpImageName(String ppImageName) {
        this.ppImageName = ppImageName;
    }

    public String getPpImageType() {
        return ppImageType;
    }

    public void setPpImageType(String ppImageType) {
        this.ppImageType = ppImageType;
    }

    public String getPpNo() {
        return ppNo;
    }

    public void setPpNo(String ppNo) {
        this.ppNo = ppNo;
    }

    public String getPpIssuedPlace() {
        return ppIssuedPlace;
    }

    public void setPpIssuedPlace(String ppIssuedPlace) {
        this.ppIssuedPlace = ppIssuedPlace;
    }

    public Date getPpIssuedDate() {
        return ppIssuedDate;
    }

    public void setPpIssuedDate(Date ppIssuedDate) {
        this.ppIssuedDate = ppIssuedDate;
    }

    public Date getPpExpireDate() {
        return ppExpireDate;
    }

    public void setPpExpireDate(Date ppExpireDate) {
        this.ppExpireDate = ppExpireDate;
    }

    public byte[] getCdcImage() {
        return cdcImage;
    }

    public void setCdcImage(byte[] cdcImage) {
        this.cdcImage = cdcImage;
    }

    public String getCdcImageName() {
        return cdcImageName;
    }

    public void setCdcImageName(String cdcImageName) {
        this.cdcImageName = cdcImageName;
    }

    public String getCdcImageType() {
        return cdcImageType;
    }

    public void setCdcImageType(String cdcImageType) {
        this.cdcImageType = cdcImageType;
    }

    public String getCdcNo() {
        return cdcNo;
    }

    public void setCdcNo(String cdcNo) {
        this.cdcNo = cdcNo;
    }

    public String getCdcIssuedPlace() {
        return cdcIssuedPlace;
    }

    public void setCdcIssuedPlace(String cdcIssuedPlace) {
        this.cdcIssuedPlace = cdcIssuedPlace;
    }

    public Date getCdcIssuedDate() {
        return cdcIssuedDate;
    }

    public void setCdcIssuedDate(Date cdcIssuedDate) {
        this.cdcIssuedDate = cdcIssuedDate;
    }

    public Date getCdcExpireDate() {
        return cdcExpireDate;
    }

    public void setCdcExpireDate(Date cdcExpireDate) {
        this.cdcExpireDate = cdcExpireDate;
    }

    public byte[] getYellowFeverImage() {
        return yellowFeverImage;
    }

    public void setYellowFeverImage(byte[] yellowFeverImage) {
        this.yellowFeverImage = yellowFeverImage;
    }

    public String getYellowFeverImageName() {
        return yellowFeverImageName;
    }

    public void setYellowFeverImageName(String yellowFeverImageName) {
        this.yellowFeverImageName = yellowFeverImageName;
    }

    public String getJobPostImageType() {
        return jobPostImageType;
    }

    public void setJobPostImageType(String jobPostImageType) {
        this.jobPostImageType = jobPostImageType;
    }

    public String getYellowFeverNo() {
        return yellowFeverNo;
    }

    public void setYellowFeverNo(String yellowFeverNo) {
        this.yellowFeverNo = yellowFeverNo;
    }

    public String getYellowFeverIssuedPlace() {
        return yellowFeverIssuedPlace;
    }

    public void setYellowFeverIssuedPlace(String yellowFeverIssuedPlace) {
        this.yellowFeverIssuedPlace = yellowFeverIssuedPlace;
    }

    public Date getYellowFeverIssuedDate() {
        return yellowFeverIssuedDate;
    }

    public void setYellowFeverIssuedDate(Date yellowFeverIssuedDate) {
        this.yellowFeverIssuedDate = yellowFeverIssuedDate;
    }

    public Date getYellowFeverExpireDate() {
        return yellowFeverExpireDate;
    }

    public void setYellowFeverExpireDate(Date yellowFeverExpireDate) {
        this.yellowFeverExpireDate = yellowFeverExpireDate;
    }
}
