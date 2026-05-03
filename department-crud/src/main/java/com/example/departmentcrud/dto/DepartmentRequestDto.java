package com.example.departmentcrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DepartmentRequestDto {
    @NotBlank
    @Size(max = 120)
    private String name;

    @NotBlank
    @Size(max = 120)
    private String head;

    @NotBlank
    @Size(max = 60)
    private String status;

    public DepartmentRequestDto() {}

    public String getName() { return name; }
    public String getHead() { return head; }
    public String getStatus() { return status; }
    public void setName(String name) { this.name = name; }
    public void setHead(String head) { this.head = head; }
    public void setStatus(String status) { this.status = status; }
}
