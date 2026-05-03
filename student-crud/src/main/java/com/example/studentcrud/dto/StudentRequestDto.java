package com.example.studentcrud.dto;

import jakarta.validation.constraints.*;

public class StudentRequestDto {

    @NotBlank
    @Size(max = 120)
    private String fullName;

    @NotBlank
    @Email
    @Size(max = 180)
    private String email;

    @NotNull
    @Min(16)
    @Max(100)
    private Integer age;

    public StudentRequestDto() {
    }

    public StudentRequestDto(String fullName, String email, Integer age) {
        this.fullName = fullName;
        this.email = email;
        this.age = age;
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
