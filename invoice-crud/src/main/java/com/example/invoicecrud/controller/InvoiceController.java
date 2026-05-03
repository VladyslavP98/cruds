package com.example.invoicecrud.controller;

import com.example.invoicecrud.dto.InvoiceRequestDto;
import com.example.invoicecrud.dto.InvoiceResponseDto;
import com.example.invoicecrud.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceResponseDto create(@Valid @RequestBody InvoiceRequestDto requestDto) { return service.create(requestDto); }

    @GetMapping
    public List<InvoiceResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public InvoiceResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public InvoiceResponseDto update(@PathVariable Long id, @Valid @RequestBody InvoiceRequestDto requestDto) {
        return service.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
