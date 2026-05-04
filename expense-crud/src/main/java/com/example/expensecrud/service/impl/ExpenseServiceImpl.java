package com.example.expensecrud.service.impl;

import com.example.expensecrud.dto.ExpenseRequestDto;
import com.example.expensecrud.dto.ExpenseResponseDto;
import com.example.expensecrud.entity.Expense;
import com.example.expensecrud.exception.ResourceNotFoundException;
import com.example.expensecrud.repository.ExpenseRepository;
import com.example.expensecrud.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseServiceImpl(ExpenseRepository repository) { this.repository = repository; }

    public ExpenseResponseDto create(ExpenseRequestDto dto) {
        Expense e = new Expense();
        e.setCategory(dto.getCategory());
        e.setAmountNote(dto.getAmountNote());
        e.setCurrency(dto.getCurrency());
        Expense s = repository.save(e);
        return new ExpenseResponseDto(s.getId(), s.getCategory(), s.getAmountNote(), s.getCurrency());
    }

    public List<ExpenseResponseDto> findAll() {
        return repository.findAll().stream().map(e -> new ExpenseResponseDto(e.getId(), e.getCategory(), e.getAmountNote(), e.getCurrency())).toList();
    }

    public ExpenseResponseDto findById(Long id) {
        Expense e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
        return new ExpenseResponseDto(e.getId(), e.getCategory(), e.getAmountNote(), e.getCurrency());
    }

    public ExpenseResponseDto update(Long id, ExpenseRequestDto dto) {
        Expense e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
        e.setCategory(dto.getCategory());
        e.setAmountNote(dto.getAmountNote());
        e.setCurrency(dto.getCurrency());
        Expense s = repository.save(e);
        return new ExpenseResponseDto(s.getId(), s.getCategory(), s.getAmountNote(), s.getCurrency());
    }

    public void delete(Long id) {
        Expense e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
        repository.delete(e);
    }
}
