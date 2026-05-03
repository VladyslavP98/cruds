package com.example.assetcrud.dto;

public class AssetResponseDto {
    private Long id;
    private String assetName;
    private String assetType;
    private String condition;

    public AssetResponseDto() {}

    public AssetResponseDto(Long id, String assetName, String assetType, String condition) {
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
