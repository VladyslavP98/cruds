package com.example.paymentcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String method;

    @Column(nullable = false, length = 120)
    private String currency;

    @Column(nullable = false, length = 60)
    private String status;

    public Payment() {}

    public Payment(Long id, String method, String currency, String status) {
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
