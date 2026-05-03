package com.example.warehousecrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class WarehouseRequestDto {
    @NotBlank
    @Size(max = 120)
    private String location;

    @NotBlank
    @Size(max = 120)
    private String managerName;

    @NotBlank
    @Size(max = 60)
    private String capacityCode;

    public WarehouseRequestDto() {}

    public WarehouseRequestDto(String location, String managerName, String capacityCode) {
        this.location = location;
        this.managerName = managerName;
        this.capacityCode = capacityCode;
    }

    public String getLocation() { return location; }
    public String getManagerName() { return managerName; }
    public String getCapacityCode() { return capacityCode; }
    public void setLocation(String location) { this.location = location; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
    public void setCapacityCode(String capacityCode) { this.capacityCode = capacityCode; }
}
