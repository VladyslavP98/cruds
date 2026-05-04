package com.example.reservationcrud.dto;

public class ReservationResponseDto {
    private Long id;
    private String reservedBy;
    private String resourceName;
    private String status;

    public ReservationResponseDto() {}
    public ReservationResponseDto(Long id, String reservedBy, String resourceName, String status) {
        this.id = id;
        this.reservedBy = reservedBy;
        this.resourceName = resourceName;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getReservedBy() { return reservedBy; }
    public String getResourceName() { return resourceName; }
    public String getStatus() { return status; }
}
