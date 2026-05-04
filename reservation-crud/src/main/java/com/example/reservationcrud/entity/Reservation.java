package com.example.reservationcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String reservedBy;

    @Column(nullable = false, length = 120)
    private String resourceName;

    @Column(nullable = false, length = 60)
    private String status;

    public Reservation() {}

    public Long getId() { return id; }
    public String getReservedBy() { return reservedBy; }
    public String getResourceName() { return resourceName; }
    public String getStatus() { return status; }
    public void setId(Long id) { this.id = id; }
    public void setReservedBy(String reservedBy) { this.reservedBy = reservedBy; }
    public void setResourceName(String resourceName) { this.resourceName = resourceName; }
    public void setStatus(String status) { this.status = status; }
}
