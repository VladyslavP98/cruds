package com.example.paymentcrud.service.impl;

import com.example.paymentcrud.dto.PaymentRequestDto;
import com.example.paymentcrud.dto.PaymentResponseDto;
import com.example.paymentcrud.entity.Payment;
import com.example.paymentcrud.exception.ResourceNotFoundException;
import com.example.paymentcrud.repository.PaymentRepository;
import com.example.paymentcrud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repository;

    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public PaymentResponseDto create(PaymentRequestDto requestDto) {
        Payment entity = toEntity(requestDto);
        return toResponseDto(repository.save(entity));
    }

    @Override
    public List<PaymentResponseDto> findAll() {
        return repository.findAll().stream().map(this::toResponseDto).toList();
    }

    @Override
    public PaymentResponseDto findById(Long id) {
        Payment entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + id));
        return toResponseDto(entity);
    }

    @Override
    public PaymentResponseDto update(Long id, PaymentRequestDto requestDto) {
        Payment entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + id));

        entity.setMethod(requestDto.getMethod());
        entity.setCurrency(requestDto.getCurrency());
        entity.setStatus(requestDto.getStatus());
        return toResponseDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        Payment entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + id));
        repository.delete(entity);
    }

    private Payment toEntity(PaymentRequestDto dto) {
        Payment entity = new Payment();
        entity.setMethod(dto.getMethod());
        entity.setCurrency(dto.getCurrency());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    private PaymentResponseDto toResponseDto(Payment entity) {
        return new PaymentResponseDto(entity.getId(), entity.getMethod(), entity.getCurrency(), entity.getStatus());
    }
}
