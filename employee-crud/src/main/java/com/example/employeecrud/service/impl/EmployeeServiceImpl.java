package com.example.employeecrud.service.impl;

import com.example.employeecrud.dto.EmployeeRequestDto;
import com.example.employeecrud.dto.EmployeeResponseDto;
import com.example.employeecrud.entity.Employee;
import com.example.employeecrud.exception.ResourceNotFoundException;
import com.example.employeecrud.repository.EmployeeRepository;
import com.example.employeecrud.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeResponseDto create(EmployeeRequestDto requestDto) {
        Employee entity = toEntity(requestDto);
        return toResponseDto(repository.save(entity));
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        return repository.findAll().stream().map(this::toResponseDto).toList();
    }

    @Override
    public EmployeeResponseDto findById(Long id) {
        Employee entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return toResponseDto(entity);
    }

    @Override
    public EmployeeResponseDto update(Long id, EmployeeRequestDto requestDto) {
        Employee entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        entity.setFirstName(requestDto.getFirstName());
        entity.setLastName(requestDto.getLastName());
        entity.setPosition(requestDto.getPosition());
        return toResponseDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        Employee entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        repository.delete(entity);
    }

    private Employee toEntity(EmployeeRequestDto dto) {
        Employee entity = new Employee();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPosition(dto.getPosition());
        return entity;
    }

    private EmployeeResponseDto toResponseDto(Employee entity) {
        return new EmployeeResponseDto(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getPosition());
    }
}
