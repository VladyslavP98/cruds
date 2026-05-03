package com.example.invoicecrud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class InvoiceRequestDto {

    @NotBlank
    @Size(max = 120)
    private String invoiceNumber;

    @NotBlank
    @Email
    @Size(max = 180)
    private String clientName;

    @NotBlank
    @Size(min = 7, max = 25)
    private String status;

    public InvoiceRequestDto() {
    }

    public InvoiceRequestDto(String invoiceNumber, String clientName, String status) {
        this.invoiceNumber = invoiceNumber;
        this.clientName = clientName;
        this.status = status;
    }

    public String getFullName() { return invoiceNumber; }
    public String getEmail() { return clientName; }
    public String getPhone() { return status; }
    public void setFullName(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
    public void setEmail(String clientName) { this.clientName = clientName; }
    public void setPhone(String status) { this.status = status; }
}
