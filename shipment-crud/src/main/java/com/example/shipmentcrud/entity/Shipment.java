package com.example.shipmentcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String trackingNumber;

    @Column(nullable = false, length = 120)
    private String carrier;

    @Column(nullable = false, length = 60)
    private String status;

    public Shipment() {}

    public Shipment(Long id, String trackingNumber, String carrier, String status) {
        this.id = id;
        this.trackingNumber = trackingNumber;
        this.carrier = carrier;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getTrackingNumber() { return trackingNumber; }
    public String getCarrier() { return carrier; }
    public String getStatus() { return status; }
    public void setId(Long id) { this.id = id; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }
    public void setCarrier(String carrier) { this.carrier = carrier; }
    public void setStatus(String status) { this.status = status; }
}
