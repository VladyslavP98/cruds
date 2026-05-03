package com.example.ordercrud.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class OrderRequestDto {

    @NotBlank
    @Size(max = 60)
    private String orderNumber;

    @NotBlank
    @Size(max = 140)
    private String customerName;

    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal totalAmount;

    public OrderRequestDto() {
    }

    public OrderRequestDto(String orderNumber, String customerName, BigDecimal totalAmount) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
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
