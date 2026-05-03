package com.example.assetcrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AssetRequestDto {
    @NotBlank
    @Size(max = 120)
    private String assetName;

    @NotBlank
    @Size(max = 120)
    private String assetType;

    @NotBlank
    @Size(max = 60)
    private String condition;

    public AssetRequestDto() {}

    public String getAssetName() { return assetName; }
    public String getAssetType() { return assetType; }
    public String getCondition() { return condition; }
    public void setAssetName(String assetName) { this.assetName = assetName; }
    public void setAssetType(String assetType) { this.assetType = assetType; }
    public void setCondition(String condition) { this.condition = condition; }
}
