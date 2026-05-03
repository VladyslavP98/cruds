package com.example.projectcrud.dto;

public class ProjectResponseDto {
    private Long id;
    private String name;
    private String owner;
    private String phase;

    public ProjectResponseDto() {}
    public ProjectResponseDto(Long id, String name, String owner, String phase) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.phase = phase;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getOwner() { return owner; }
    public String getPhase() { return phase; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setPhase(String phase) { this.phase = phase; }
}
