package com.example.vendorcrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VendorRequestDto {
    @NotBlank
    @Size(max = 120)
    private String companyName;

    @NotBlank
    @Size(max = 120)
    private String contactPerson;

    @NotBlank
    @Size(max = 60)
    private String status;

    public VendorRequestDto() {}

    public String getCompanyName() { return companyName; }
    public String getContactPerson() { return contactPerson; }
    public String getStatus() { return status; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }
    public void setStatus(String status) { this.status = status; }
}
