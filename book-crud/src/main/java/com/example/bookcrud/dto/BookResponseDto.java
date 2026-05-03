package com.example.bookcrud.dto;

public class BookResponseDto {

    private Long id;
    private String title;
    private String author;
    private String isbn;

    public BookResponseDto() {
    }

    public BookResponseDto(Long id, String title, String author, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public Long getId() { return id; }
    public String getFullName() { return title; }
    public String getEmail() { return author; }
    public String getPhone() { return isbn; }
    public void setId(Long id) { this.id = id; }
    public void setFullName(String title) { this.title = title; }
    public void setEmail(String author) { this.author = author; }
    public void setPhone(String isbn) { this.isbn = isbn; }
}
