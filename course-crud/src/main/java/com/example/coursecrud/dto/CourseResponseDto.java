package com.example.coursecrud.dto;

public class CourseResponseDto {
    private Long id;
    private String title;
    private String instructor;
    private String level;

    public CourseResponseDto() {}
    public CourseResponseDto(Long id, String title, String instructor, String level) {
        this.id = id;
        this.title = title;
        this.instructor = instructor;
        this.level = level;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getInstructor() { return instructor; }
    public String getLevel() { return level; }
}
