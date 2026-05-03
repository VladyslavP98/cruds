package com.example.bookcrud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BookRequestDto {

    @NotBlank
    @Size(max = 120)
    private String title;

    @NotBlank
    @Email
    @Size(max = 180)
    private String author;

    @NotBlank
    @Size(min = 7, max = 25)
    private String isbn;

    public BookRequestDto() {
    }

    public BookRequestDto(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getFullName() { return title; }
    public String getEmail() { return author; }
    public String getPhone() { return isbn; }
    public void setFullName(String title) { this.title = title; }
    public void setEmail(String author) { this.author = author; }
    public void setPhone(String isbn) { this.isbn = isbn; }
}
