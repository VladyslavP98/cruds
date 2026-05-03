package com.example.paymentcrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PaymentRequestDto {
    @NotBlank
    @Size(max = 120)
    private String method;

    @NotBlank
    @Size(max = 120)
    private String currency;

    @NotBlank
    @Size(max = 60)
    private String status;

    public PaymentRequestDto() {}

    public PaymentRequestDto(String method, String currency, String status) {
        this.method = method;
        this.currency = currency;
        this.status = status;
    }

    public String getMethod() { return method; }
    public String getCurrency() { return currency; }
    public String getStatus() { return status; }
    public void setMethod(String method) { this.method = method; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setStatus(String status) { this.status = status; }
}
