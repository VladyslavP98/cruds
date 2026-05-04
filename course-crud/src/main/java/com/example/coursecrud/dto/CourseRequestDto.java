package com.example.coursecrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CourseRequestDto {
    @NotBlank @Size(max = 120)
    private String title;
    @NotBlank @Size(max = 120)
    private String instructor;
    @NotBlank @Size(max = 60)
    private String level;

    public String getTitle() { return title; }
    public String getInstructor() { return instructor; }
    public String getLevel() { return level; }
    public void setTitle(String title) { this.title = title; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setLevel(String level) { this.level = level; }
}
