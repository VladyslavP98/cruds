package com.example.suppliercrud.service.impl;

import com.example.suppliercrud.dto.SupplierRequestDto;
import com.example.suppliercrud.dto.SupplierResponseDto;
import com.example.suppliercrud.entity.Supplier;
import com.example.suppliercrud.exception.ResourceNotFoundException;
import com.example.suppliercrud.repository.SupplierRepository;
import com.example.suppliercrud.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository repository;

    public SupplierServiceImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupplierResponseDto create(SupplierRequestDto requestDto) {
        Supplier entity = toEntity(requestDto);
        return toResponseDto(repository.save(entity));
    }

    @Override
    public List<SupplierResponseDto> findAll() {
        return repository.findAll().stream().map(this::toResponseDto).toList();
    }

    @Override
    public SupplierResponseDto findById(Long id) {
        Supplier entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
        return toResponseDto(entity);
    }

    @Override
    public SupplierResponseDto update(Long id, SupplierRequestDto requestDto) {
        Supplier entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));

        entity.setCompanyName(requestDto.getCompanyName());
        entity.setContactName(requestDto.getContactName());
        entity.setPhone(requestDto.getPhone());
        return toResponseDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        Supplier entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
        repository.delete(entity);
    }

    private Supplier toEntity(SupplierRequestDto dto) {
        Supplier entity = new Supplier();
        entity.setCompanyName(dto.getCompanyName());
        entity.setContactName(dto.getContactName());
        entity.setPhone(dto.getPhone());
        return entity;
    }

    private SupplierResponseDto toResponseDto(Supplier entity) {
        return new SupplierResponseDto(entity.getId(), entity.getCompanyName(), entity.getContactName(), entity.getPhone());
    }
}
