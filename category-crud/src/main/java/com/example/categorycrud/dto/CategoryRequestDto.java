package com.example.categorycrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryRequestDto {
    @NotBlank
    @Size(max = 120)
    private String name;

    @NotBlank
    @Size(max = 120)
    private String description;

    @NotBlank
    @Size(max = 60)
    private String code;

    public CategoryRequestDto() {}

    public CategoryRequestDto(String name, String description, String code) {
        this.name = name;
        this.description = description;
        this.code = code;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCode() { return code; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setCode(String code) { this.code = code; }
}
