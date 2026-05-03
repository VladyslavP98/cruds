package com.example.paymentcrud.service;

import com.example.paymentcrud.dto.PaymentRequestDto;
import com.example.paymentcrud.dto.PaymentResponseDto;

import java.util.List;

public interface PaymentService {
    PaymentResponseDto create(PaymentRequestDto requestDto);
    List<PaymentResponseDto> findAll();
    PaymentResponseDto findById(Long id);
    PaymentResponseDto update(Long id, PaymentRequestDto requestDto);
    void delete(Long id);
}
