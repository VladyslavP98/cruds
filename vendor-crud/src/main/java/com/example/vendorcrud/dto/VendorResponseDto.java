package com.example.vendorcrud.dto;

public class VendorResponseDto {
    private Long id;
    private String companyName;
    private String contactPerson;
    private String status;

    public VendorResponseDto() {}

    public VendorResponseDto(Long id, String companyName, String contactPerson, String status) {
        this.id = id;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getCompanyName() { return companyName; }
    public String getContactPerson() { return contactPerson; }
    public String getStatus() { return status; }
    public void setId(Long id) { this.id = id; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }
    public void setStatus(String status) { this.status = status; }
}
