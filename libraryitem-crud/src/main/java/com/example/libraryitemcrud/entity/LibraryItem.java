package com.example.libraryitemcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "library_items")
public class LibraryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String code;

    @Column(nullable = false, length = 120)
    private String itemType;

    @Column(nullable = false, length = 60)
    private String state;

    public LibraryItem() {}

    public Long getId() { return id; }
    public String getCode() { return code; }
    public String getItemType() { return itemType; }
    public String getState() { return state; }
    public void setId(Long id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setItemType(String itemType) { this.itemType = itemType; }
    public void setState(String state) { this.state = state; }
}
