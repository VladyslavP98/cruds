package com.example.expensecrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String category;

    @Column(nullable = false, length = 120)
    private String amountNote;

    @Column(nullable = false, length = 60)
    private String currency;

    public Expense() {}

    public Long getId() { return id; }
    public String getCategory() { return category; }
    public String getAmountNote() { return amountNote; }
    public String getCurrency() { return currency; }
    public void setId(Long id) { this.id = id; }
    public void setCategory(String category) { this.category = category; }
    public void setAmountNote(String amountNote) { this.amountNote = amountNote; }
    public void setCurrency(String currency) { this.currency = currency; }
}
