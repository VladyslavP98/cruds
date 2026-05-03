package com.example.shipmentcrud.dto;

public class ShipmentResponseDto {
    private Long id;
    private String trackingNumber;
    private String carrier;
    private String status;

    public ShipmentResponseDto() {}

    public ShipmentResponseDto(Long id, String trackingNumber, String carrier, String status) {
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
