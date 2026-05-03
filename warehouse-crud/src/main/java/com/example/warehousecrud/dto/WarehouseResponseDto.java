package com.example.warehousecrud.dto;

public class WarehouseResponseDto {
    private Long id;
    private String location;
    private String managerName;
    private String capacityCode;

    public WarehouseResponseDto() {}

    public WarehouseResponseDto(Long id, String location, String managerName, String capacityCode) {
        this.id = id;
        this.location = location;
        this.managerName = managerName;
        this.capacityCode = capacityCode;
    }

    public Long getId() { return id; }
    public String getLocation() { return location; }
    public String getManagerName() { return managerName; }
    public String getCapacityCode() { return capacityCode; }
    public void setId(Long id) { this.id = id; }
    public void setLocation(String location) { this.location = location; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
    public void setCapacityCode(String capacityCode) { this.capacityCode = capacityCode; }
}
