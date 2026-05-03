package com.example.customercrud.controller;

import com.example.customercrud.dto.CustomerRequestDto;
import com.example.customercrud.dto.CustomerResponseDto;
import com.example.customercrud.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDto create(@Valid @RequestBody CustomerRequestDto requestDto) { return service.create(requestDto); }

    @GetMapping
    public List<CustomerResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public CustomerResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public CustomerResponseDto update(@PathVariable Long id, @Valid @RequestBody CustomerRequestDto requestDto) {
        return service.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
