package com.bit.backend.dtos;

public class StocksDto {

    private Long id;
    private String itemNo;
    private String itemName;
    private String supplierName;
    private String quantity;
    private String qtyMeasure;

    public StocksDto() {
    }

    public StocksDto(Long id, String itemNo, String itemName, String supplierName, String quantity, String qtyMeasure) {
        this.id = id;
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.qtyMeasure = qtyMeasure;
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
}
