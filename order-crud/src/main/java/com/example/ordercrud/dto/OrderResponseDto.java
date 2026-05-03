package com.example.ordercrud.dto;

import java.math.BigDecimal;

public class OrderResponseDto {

    private Long id;
    private String orderNumber;
    private String customerName;
    private BigDecimal totalAmount;

    public OrderResponseDto() {
    }

    public OrderResponseDto(Long id, String orderNumber, String customerName, BigDecimal totalAmount) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
