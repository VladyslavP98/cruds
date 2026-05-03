package com.example.shipmentcrud.service;

import com.example.shipmentcrud.dto.ShipmentRequestDto;
import com.example.shipmentcrud.dto.ShipmentResponseDto;

import java.util.List;

public interface ShipmentService {
    ShipmentResponseDto create(ShipmentRequestDto requestDto);
    List<ShipmentResponseDto> findAll();
    ShipmentResponseDto findById(Long id);
    ShipmentResponseDto update(Long id, ShipmentRequestDto requestDto);
    void delete(Long id);
}
