package com.example.shipmentcrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ShipmentRequestDto {
    @NotBlank
    @Size(max = 120)
    private String trackingNumber;

    @NotBlank
    @Size(max = 120)
    private String carrier;

    @NotBlank
    @Size(max = 60)
    private String status;

    public ShipmentRequestDto() {}

    public ShipmentRequestDto(String trackingNumber, String carrier, String status) {
        this.trackingNumber = trackingNumber;
        this.carrier = carrier;
        this.status = status;
    }

    public String getTrackingNumber() { return trackingNumber; }
    public String getCarrier() { return carrier; }
    public String getStatus() { return status; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }
    public void setCarrier(String carrier) { this.carrier = carrier; }
    public void setStatus(String status) { this.status = status; }
}
