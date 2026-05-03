package com.example.projectcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 140)
    private String name;
    @Column(nullable = false, length = 60)
    private String owner;
    @Column(nullable = false, length = 30)
    private String phase;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getOwner() { return owner; }
    public String getPhase() { return phase; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setPhase(String phase) { this.phase = phase; }
}
