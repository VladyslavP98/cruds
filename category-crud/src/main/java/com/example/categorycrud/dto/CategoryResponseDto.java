package com.example.categorycrud.dto;

public class CategoryResponseDto {
    private Long id;
    private String name;
    private String description;
    private String code;

    public CategoryResponseDto() {}

    public CategoryResponseDto(Long id, String name, String description, String code) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.code = code;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCode() { return code; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setCode(String code) { this.code = code; }
}
