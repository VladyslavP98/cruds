package com.example.suppliercrud.dto;

public class SupplierResponseDto {
    private Long id;
    private String companyName;
    private String contactName;
    private String phone;

    public SupplierResponseDto() {}

    public SupplierResponseDto(Long id, String companyName, String contactName, String phone) {
        this.id = id;
        this.companyName = companyName;
        this.contactName = contactName;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public String getCompanyName() { return companyName; }
    public String getContactName() { return contactName; }
    public String getPhone() { return phone; }
    public void setId(Long id) { this.id = id; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public void setContactName(String contactName) { this.contactName = contactName; }
    public void setPhone(String phone) { this.phone = phone; }
}
