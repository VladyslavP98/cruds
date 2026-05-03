package com.example.invoicecrud.dto;

public class InvoiceResponseDto {

    private Long id;
    private String invoiceNumber;
    private String clientName;
    private String status;

    public InvoiceResponseDto() {
    }

    public InvoiceResponseDto(Long id, String invoiceNumber, String clientName, String status) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.clientName = clientName;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getFullName() { return invoiceNumber; }
    public String getEmail() { return clientName; }
    public String getPhone() { return status; }
    public void setId(Long id) { this.id = id; }
    public void setFullName(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
    public void setEmail(String clientName) { this.clientName = clientName; }
    public void setPhone(String status) { this.status = status; }
}
