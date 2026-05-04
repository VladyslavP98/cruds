package com.example.reservationcrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ReservationRequestDto {
    @NotBlank @Size(max = 120)
    private String reservedBy;
    @NotBlank @Size(max = 120)
    private String resourceName;
    @NotBlank @Size(max = 60)
    private String status;

    public String getReservedBy() { return reservedBy; }
    public String getResourceName() { return resourceName; }
    public String getStatus() { return status; }
    public void setReservedBy(String reservedBy) { this.reservedBy = reservedBy; }
    public void setResourceName(String resourceName) { this.resourceName = resourceName; }
    public void setStatus(String status) { this.status = status; }
}
