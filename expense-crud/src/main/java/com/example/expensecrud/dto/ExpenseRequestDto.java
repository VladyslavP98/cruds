package com.example.expensecrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ExpenseRequestDto {
    @NotBlank @Size(max = 120)
    private String category;
    @NotBlank @Size(max = 120)
    private String amountNote;
    @NotBlank @Size(max = 60)
    private String currency;

    public String getCategory() { return category; }
    public String getAmountNote() { return amountNote; }
    public String getCurrency() { return currency; }
    public void setCategory(String category) { this.category = category; }
    public void setAmountNote(String amountNote) { this.amountNote = amountNote; }
    public void setCurrency(String currency) { this.currency = currency; }
}
