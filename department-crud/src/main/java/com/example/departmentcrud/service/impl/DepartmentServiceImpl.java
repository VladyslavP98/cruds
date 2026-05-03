package com.example.departmentcrud.service.impl;

import com.example.departmentcrud.dto.DepartmentRequestDto;
import com.example.departmentcrud.dto.DepartmentResponseDto;
import com.example.departmentcrud.entity.Department;
import com.example.departmentcrud.exception.ResourceNotFoundException;
import com.example.departmentcrud.repository.DepartmentRepository;
import com.example.departmentcrud.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    public DepartmentResponseDto create(DepartmentRequestDto requestDto) {
        Department entity = new Department();
        entity.setName(requestDto.getName());
        entity.setHead(requestDto.getHead());
        entity.setStatus(requestDto.getStatus());
        Department saved = repository.save(entity);
        return new DepartmentResponseDto(saved.getId(), saved.getName(), saved.getHead(), saved.getStatus());
    }

    public List<DepartmentResponseDto> findAll() {
        return repository.findAll().stream()
                .map(e -> new DepartmentResponseDto(e.getId(), e.getName(), e.getHead(), e.getStatus()))
                .toList();
    }

    public DepartmentResponseDto findById(Long id) {
        Department e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
        return new DepartmentResponseDto(e.getId(), e.getName(), e.getHead(), e.getStatus());
    }

    public DepartmentResponseDto update(Long id, DepartmentRequestDto requestDto) {
        Department e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
        e.setName(requestDto.getName());
        e.setHead(requestDto.getHead());
        e.setStatus(requestDto.getStatus());
        Department saved = repository.save(e);
        return new DepartmentResponseDto(saved.getId(), saved.getName(), saved.getHead(), saved.getStatus());
    }

    public void delete(Long id) {
        Department e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
        repository.delete(e);
    }
}
