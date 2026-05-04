package com.example.expensecrud.service;

import com.example.expensecrud.dto.ExpenseRequestDto;
import com.example.expensecrud.dto.ExpenseResponseDto;

import java.util.List;

public interface ExpenseService {
    ExpenseResponseDto create(ExpenseRequestDto requestDto);
    List<ExpenseResponseDto> findAll();
    ExpenseResponseDto findById(Long id);
    ExpenseResponseDto update(Long id, ExpenseRequestDto requestDto);
    void delete(Long id);
}
