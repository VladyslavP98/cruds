package com.example.taskcrud.dto;

public class TaskResponseDto {
    private Long id;
    private String title;
    private String assignee;
    private String progress;

    public TaskResponseDto() {}

    public TaskResponseDto(Long id, String title, String assignee, String progress) {
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
