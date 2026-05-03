package com.example.warehousecrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String location;

    @Column(nullable = false, length = 120)
    private String managerName;

    @Column(nullable = false, length = 60)
    private String capacityCode;

    public Warehouse() {}

    public Warehouse(Long id, String location, String managerName, String capacityCode) {
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
