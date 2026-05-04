package com.example.expensecrud.controller;

import com.example.expensecrud.dto.ExpenseRequestDto;
import com.example.expensecrud.dto.ExpenseResponseDto;
import com.example.expensecrud.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService service;

    public ExpenseController(ExpenseService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExpenseResponseDto create(@Valid @RequestBody ExpenseRequestDto dto) { return service.create(dto); }

    @GetMapping
    public List<ExpenseResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ExpenseResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public ExpenseResponseDto update(@PathVariable Long id, @Valid @RequestBody ExpenseRequestDto dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
