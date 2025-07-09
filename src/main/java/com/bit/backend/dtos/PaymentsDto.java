package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class PaymentsDto {

    private Long id;
    private String paymentNo ;
    private String itemName ;
    private String supplierName ;
    private String quantity ;
    private String qtyMeasure;
    private String amount ;
    private Date paymentDate ;
    private String paymentStatus ;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] paymentImage;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String paymentImageName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String paymentImageType;

    public PaymentsDto() {
    }

    public PaymentsDto(Long id, String paymentNo, String itemName, String supplierName, String quantity, String qtyMeasure, String amount, Date paymentDate, String paymentStatus, byte[] paymentImage, String paymentImageName, String paymentImageType) {
        this.id = id;
        this.paymentNo = paymentNo;
        this.itemName = itemName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.qtyMeasure = qtyMeasure;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        this.paymentImage = paymentImage;
        this.paymentImageName = paymentImageName;
        this.paymentImageType = paymentImageType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQtyMeasure() {
        return qtyMeasure;
    }

    public void setQtyMeasure(String qtyMeasure) {
        this.qtyMeasure = qtyMeasure;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public byte[] getPaymentImage() {
        return paymentImage;
    }

    public void setPaymentImage(byte[] paymentImage) {
        this.paymentImage = paymentImage;
    }

    public String getPaymentImageName() {
        return paymentImageName;
    }

    public void setPaymentImageName(String paymentImageName) {
        this.paymentImageName = paymentImageName;
    }

    public String getPaymentImageType() {
        return paymentImageType;
    }

    public void setPaymentImageType(String paymentImageType) {
        this.paymentImageType = paymentImageType;
    }
}
