package com.example.departmentcrud.dto;

public class DepartmentResponseDto {
    private Long id;
    private String name;
    private String head;
    private String status;

    public DepartmentResponseDto() {}

    public DepartmentResponseDto(Long id, String name, String head, String status) {
        this.id = id;
        this.name = name;
        this.head = head;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getHead() { return head; }
    public String getStatus() { return status; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setHead(String head) { this.head = head; }
    public void setStatus(String status) { this.status = status; }
}
