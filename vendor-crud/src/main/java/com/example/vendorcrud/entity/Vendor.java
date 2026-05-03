package com.example.vendorcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String companyName;

    @Column(nullable = false, length = 120)
    private String contactPerson;

    @Column(nullable = false, length = 60)
    private String status;

    public Vendor() {}

    public Vendor(Long id, String companyName, String contactPerson, String status) {
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
