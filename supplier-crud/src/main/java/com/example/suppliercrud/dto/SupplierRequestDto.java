package com.example.suppliercrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SupplierRequestDto {
    @NotBlank
    @Size(max = 120)
    private String companyName;

    @NotBlank
    @Size(max = 120)
    private String contactName;

    @NotBlank
    @Size(max = 60)
    private String phone;

    public SupplierRequestDto() {}

    public SupplierRequestDto(String companyName, String contactName, String phone) {
        this.companyName = companyName;
        this.contactName = contactName;
        this.phone = phone;
    }

    public String getCompanyName() { return companyName; }
    public String getContactName() { return contactName; }
    public String getPhone() { return phone; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public void setContactName(String contactName) { this.contactName = contactName; }
    public void setPhone(String phone) { this.phone = phone; }
}
