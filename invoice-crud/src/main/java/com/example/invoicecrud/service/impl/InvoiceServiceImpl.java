package com.example.invoicecrud.service.impl;

import com.example.invoicecrud.dto.InvoiceRequestDto;
import com.example.invoicecrud.dto.InvoiceResponseDto;
import com.example.invoicecrud.entity.Invoice;
import com.example.invoicecrud.exception.ResourceNotFoundException;
import com.example.invoicecrud.repository.InvoiceRepository;
import com.example.invoicecrud.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository repository;

    public InvoiceServiceImpl(InvoiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public InvoiceResponseDto create(InvoiceRequestDto requestDto) {
        Invoice entity = toEntity(requestDto);
        return toResponseDto(repository.save(entity));
    }

    @Override
    public List<InvoiceResponseDto> findAll() {
        return repository.findAll().stream().map(this::toResponseDto).toList();
    }

    @Override
    public InvoiceResponseDto findById(Long id) {
        Invoice entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id: " + id));
        return toResponseDto(entity);
    }

    @Override
    public InvoiceResponseDto update(Long id, InvoiceRequestDto requestDto) {
        Invoice entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id: " + id));

        entity.setFullName(requestDto.getFullName());
        entity.setEmail(requestDto.getEmail());
        entity.setPhone(requestDto.getPhone());

        return toResponseDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        Invoice entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id: " + id));
        repository.delete(entity);
    }

    private Invoice toEntity(InvoiceRequestDto dto) {
        Invoice entity = new Invoice();
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        return entity;
    }

    private InvoiceResponseDto toResponseDto(Invoice entity) {
        return new InvoiceResponseDto(entity.getId(), entity.getFullName(), entity.getEmail(), entity.getPhone());
    }
}
