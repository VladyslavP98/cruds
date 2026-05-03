package com.example.suppliercrud.service;

import com.example.suppliercrud.dto.SupplierRequestDto;
import com.example.suppliercrud.dto.SupplierResponseDto;

import java.util.List;

public interface SupplierService {
    SupplierResponseDto create(SupplierRequestDto requestDto);
    List<SupplierResponseDto> findAll();
    SupplierResponseDto findById(Long id);
    SupplierResponseDto update(Long id, SupplierRequestDto requestDto);
    void delete(Long id);
}
