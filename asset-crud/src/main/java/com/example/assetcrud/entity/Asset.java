package com.example.assetcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "assets")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String assetName;

    @Column(nullable = false, length = 120)
    private String assetType;

    @Column(nullable = false, length = 60)
    private String condition;

    public Asset() {}

    public Asset(Long id, String assetName, String assetType, String condition) {
        this.id = id;
        this.assetName = assetName;
        this.assetType = assetType;
        this.condition = condition;
    }

    public Long getId() { return id; }
    public String getAssetName() { return assetName; }
    public String getAssetType() { return assetType; }
    public String getCondition() { return condition; }
    public void setId(Long id) { this.id = id; }
    public void setAssetName(String assetName) { this.assetName = assetName; }
    public void setAssetType(String assetType) { this.assetType = assetType; }
    public void setCondition(String condition) { this.condition = condition; }
}
