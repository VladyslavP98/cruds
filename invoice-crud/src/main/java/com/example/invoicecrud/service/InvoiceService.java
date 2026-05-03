package com.example.invoicecrud.service;

import com.example.invoicecrud.dto.InvoiceRequestDto;
import com.example.invoicecrud.dto.InvoiceResponseDto;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDto create(InvoiceRequestDto requestDto);
    List<InvoiceResponseDto> findAll();
    InvoiceResponseDto findById(Long id);
    InvoiceResponseDto update(Long id, InvoiceRequestDto requestDto);
    void delete(Long id);
}
