package com.example.studentcrud.dto;

public class StudentResponseDto {

    private Long id;
    private String fullName;
    private String email;
    private Integer age;

    public StudentResponseDto() {
    }

    public StudentResponseDto(Long id, String fullName, String email, Integer age) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
