package com.example.paymentcrud.controller;

import com.example.paymentcrud.dto.PaymentRequestDto;
import com.example.paymentcrud.dto.PaymentResponseDto;
import com.example.paymentcrud.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponseDto create(@Valid @RequestBody PaymentRequestDto requestDto) { return service.create(requestDto); }

    @GetMapping
    public List<PaymentResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public PaymentResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public PaymentResponseDto update(@PathVariable Long id, @Valid @RequestBody PaymentRequestDto requestDto) { return service.update(id, requestDto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
