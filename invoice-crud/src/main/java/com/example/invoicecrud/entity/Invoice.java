package com.example.invoicecrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String invoiceNumber;

    @Column(nullable = false, unique = true, length = 180)
    private String clientName;

    @Column(nullable = false, length = 25)
    private String status;

    public Invoice() {
    }

    public Invoice(Long id, String invoiceNumber, String clientName, String status) {
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
