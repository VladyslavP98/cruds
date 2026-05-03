package com.example.departmentcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 120)
    private String head;

    @Column(nullable = false, length = 60)
    private String status;

    public Department() {}

    public Department(Long id, String name, String head, String status) {
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
