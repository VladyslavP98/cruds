package com.example.bookcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String title;

    @Column(nullable = false, unique = true, length = 180)
    private String author;

    @Column(nullable = false, length = 25)
    private String isbn;

    public Book() {
    }

    public Book(Long id, String title, String author, String isbn) {
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
