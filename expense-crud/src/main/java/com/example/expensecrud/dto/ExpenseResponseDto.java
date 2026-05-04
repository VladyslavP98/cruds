package com.example.expensecrud.dto;

public class ExpenseResponseDto {
    private Long id;
    private String category;
    private String amountNote;
    private String currency;

    public ExpenseResponseDto() {}
    public ExpenseResponseDto(Long id, String category, String amountNote, String currency) {
        this.id = id;
        this.category = category;
        this.amountNote = amountNote;
        this.currency = currency;
    }

    public Long getId() { return id; }
    public String getCategory() { return category; }
    public String getAmountNote() { return amountNote; }
    public String getCurrency() { return currency; }
}
