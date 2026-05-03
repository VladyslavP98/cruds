package com.example.suppliercrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String companyName;

    @Column(nullable = false, length = 120)
    private String contactName;

    @Column(nullable = false, length = 60)
    private String phone;

    public Supplier() {}

    public Supplier(Long id, String companyName, String contactName, String phone) {
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
