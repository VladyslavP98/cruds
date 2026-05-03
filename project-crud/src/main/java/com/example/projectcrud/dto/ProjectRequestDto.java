package com.example.projectcrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProjectRequestDto {
    @NotBlank @Size(max = 140)
    private String name;
    @NotBlank @Size(max = 60)
    private String owner;
    @NotBlank @Size(max = 30)
    private String phase;

    public String getName() { return name; }
    public String getOwner() { return owner; }
    public String getPhase() { return phase; }
    public void setName(String name) { this.name = name; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setPhase(String phase) { this.phase = phase; }
}
