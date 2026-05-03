package com.example.shipmentcrud.service.impl;

import com.example.shipmentcrud.dto.ShipmentRequestDto;
import com.example.shipmentcrud.dto.ShipmentResponseDto;
import com.example.shipmentcrud.entity.Shipment;
import com.example.shipmentcrud.exception.ResourceNotFoundException;
import com.example.shipmentcrud.repository.ShipmentRepository;
import com.example.shipmentcrud.service.ShipmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    private final ShipmentRepository repository;

    public ShipmentServiceImpl(ShipmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShipmentResponseDto create(ShipmentRequestDto requestDto) {
        Shipment entity = toEntity(requestDto);
        return toResponseDto(repository.save(entity));
    }

    @Override
    public List<ShipmentResponseDto> findAll() {
        return repository.findAll().stream().map(this::toResponseDto).toList();
    }

    @Override
    public ShipmentResponseDto findById(Long id) {
        Shipment entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + id));
        return toResponseDto(entity);
    }

    @Override
    public ShipmentResponseDto update(Long id, ShipmentRequestDto requestDto) {
        Shipment entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + id));

        entity.setTrackingNumber(requestDto.getTrackingNumber());
        entity.setCarrier(requestDto.getCarrier());
        entity.setStatus(requestDto.getStatus());
        return toResponseDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        Shipment entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + id));
        repository.delete(entity);
    }

    private Shipment toEntity(ShipmentRequestDto dto) {
        Shipment entity = new Shipment();
        entity.setTrackingNumber(dto.getTrackingNumber());
        entity.setCarrier(dto.getCarrier());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    private ShipmentResponseDto toResponseDto(Shipment entity) {
        return new ShipmentResponseDto(entity.getId(), entity.getTrackingNumber(), entity.getCarrier(), entity.getStatus());
    }
}
