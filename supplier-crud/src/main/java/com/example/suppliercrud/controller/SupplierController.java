package com.example.suppliercrud.controller;

import com.example.suppliercrud.dto.SupplierRequestDto;
import com.example.suppliercrud.dto.SupplierResponseDto;
import com.example.suppliercrud.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    private final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SupplierResponseDto create(@Valid @RequestBody SupplierRequestDto requestDto) { return service.create(requestDto); }

    @GetMapping
    public List<SupplierResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public SupplierResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public SupplierResponseDto update(@PathVariable Long id, @Valid @RequestBody SupplierRequestDto requestDto) { return service.update(id, requestDto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
