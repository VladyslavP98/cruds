package com.example.paymentcrud.dto;

public class PaymentResponseDto {
    private Long id;
    private String method;
    private String currency;
    private String status;

    public PaymentResponseDto() {}

    public PaymentResponseDto(Long id, String method, String currency, String status) {
        this.id = id;
        this.method = method;
        this.currency = currency;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getMethod() { return method; }
    public String getCurrency() { return currency; }
    public String getStatus() { return status; }
    public void setId(Long id) { this.id = id; }
    public void setMethod(String method) { this.method = method; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setStatus(String status) { this.status = status; }
}
