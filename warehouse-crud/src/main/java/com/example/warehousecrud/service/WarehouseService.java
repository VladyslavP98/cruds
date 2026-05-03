package com.example.warehousecrud.service;

import com.example.warehousecrud.dto.WarehouseRequestDto;
import com.example.warehousecrud.dto.WarehouseResponseDto;

import java.util.List;

public interface WarehouseService {
    WarehouseResponseDto create(WarehouseRequestDto requestDto);
    List<WarehouseResponseDto> findAll();
    WarehouseResponseDto findById(Long id);
    WarehouseResponseDto update(Long id, WarehouseRequestDto requestDto);
    void delete(Long id);
}
