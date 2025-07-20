package com.bit.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "payments")
public class PaymentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_no ")
    private String paymentNo ;

    @Column(name = "item_no ")
    private Long itemNo;

    @Column(name = "item_name ")
    private String itemName ;

    @Column(name = "supplier_name ")
    private String supplierName ;

    @Column(name = "quantity ")
    private String quantity ;

    @Column(name = "qty_measure ")
    private String qtyMeasure ;

    @Column(name = "amount ")
    private String amount ;

    @Column(name = "payment_date ")
    private Date paymentDate ;

    @Column(name = "payment_status ")
    private String paymentStatus ;

    @Column(name = "payment_image")  // Photo upload
    private byte[] paymentImage;

    @Column(name = "payment_image_name")
    private String paymentImageName;

    @Column(name = "payment_image_type")
    private String paymentImageType;

    public PaymentsEntity() {
    }

    public PaymentsEntity(Long id, String paymentNo, Long itemNo, String itemName, String supplierName, String quantity, String qtyMeasure, String amount, Date paymentDate, String paymentStatus, byte[] paymentImage, String paymentImageName, String paymentImageType) {
        this.id = id;
        this.paymentNo = paymentNo;
        this.itemNo = itemNo;
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

    public Long getItemNo() {
        return itemNo;
    }

    public void setItemNo(Long itemNo) {
        this.itemNo = itemNo;
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
