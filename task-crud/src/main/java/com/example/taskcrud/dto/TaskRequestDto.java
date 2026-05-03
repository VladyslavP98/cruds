package com.example.taskcrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskRequestDto {
    @NotBlank
    @Size(max = 120)
    private String title;

    @NotBlank
    @Size(max = 120)
    private String assignee;

    @NotBlank
    @Size(max = 60)
    private String progress;

    public TaskRequestDto() {}

    public String getTitle() { return title; }
    public String getAssignee() { return assignee; }
    public String getProgress() { return progress; }
    public void setTitle(String title) { this.title = title; }
    public void setAssignee(String assignee) { this.assignee = assignee; }
    public void setProgress(String progress) { this.progress = progress; }
}
