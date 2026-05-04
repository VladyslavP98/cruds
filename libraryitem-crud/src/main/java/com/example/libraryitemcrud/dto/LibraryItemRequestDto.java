package com.example.libraryitemcrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LibraryItemRequestDto {
    @NotBlank @Size(max = 120)
    private String code;
    @NotBlank @Size(max = 120)
    private String itemType;
    @NotBlank @Size(max = 60)
    private String state;

    public String getCode() { return code; }
    public String getItemType() { return itemType; }
    public String getState() { return state; }
    public void setCode(String code) { this.code = code; }
    public void setItemType(String itemType) { this.itemType = itemType; }
    public void setState(String state) { this.state = state; }
}
