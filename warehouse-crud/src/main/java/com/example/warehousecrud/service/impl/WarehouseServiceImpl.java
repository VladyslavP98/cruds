package com.example.warehousecrud.service.impl;

import com.example.warehousecrud.dto.WarehouseRequestDto;
import com.example.warehousecrud.dto.WarehouseResponseDto;
import com.example.warehousecrud.entity.Warehouse;
import com.example.warehousecrud.exception.ResourceNotFoundException;
import com.example.warehousecrud.repository.WarehouseRepository;
import com.example.warehousecrud.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository repository;

    public WarehouseServiceImpl(WarehouseRepository repository) {
        this.repository = repository;
    }

    @Override
    public WarehouseResponseDto create(WarehouseRequestDto requestDto) {
        Warehouse entity = toEntity(requestDto);
        return toResponseDto(repository.save(entity));
    }

    @Override
    public List<WarehouseResponseDto> findAll() {
        return repository.findAll().stream().map(this::toResponseDto).toList();
    }

    @Override
    public WarehouseResponseDto findById(Long id) {
        Warehouse entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found with id: " + id));
        return toResponseDto(entity);
    }

    @Override
    public WarehouseResponseDto update(Long id, WarehouseRequestDto requestDto) {
        Warehouse entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found with id: " + id));

        entity.setLocation(requestDto.getLocation());
        entity.setManagerName(requestDto.getManagerName());
        entity.setCapacityCode(requestDto.getCapacityCode());
        return toResponseDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        Warehouse entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found with id: " + id));
        repository.delete(entity);
    }

    private Warehouse toEntity(WarehouseRequestDto dto) {
        Warehouse entity = new Warehouse();
        entity.setLocation(dto.getLocation());
        entity.setManagerName(dto.getManagerName());
        entity.setCapacityCode(dto.getCapacityCode());
        return entity;
    }

    private WarehouseResponseDto toResponseDto(Warehouse entity) {
        return new WarehouseResponseDto(entity.getId(), entity.getLocation(), entity.getManagerName(), entity.getCapacityCode());
    }
}
