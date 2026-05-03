package com.example.taskcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String title;

    @Column(nullable = false, length = 120)
    private String assignee;

    @Column(nullable = false, length = 60)
    private String progress;

    public Task() {}

    public Task(Long id, String title, String assignee, String progress) {
        this.id = id;
        this.title = title;
        this.assignee = assignee;
        this.progress = progress;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAssignee() { return assignee; }
    public String getProgress() { return progress; }
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAssignee(String assignee) { this.assignee = assignee; }
    public void setProgress(String progress) { this.progress = progress; }
}
