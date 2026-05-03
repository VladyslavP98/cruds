package com.example.departmentcrud.service;

import com.example.departmentcrud.dto.DepartmentRequestDto;
import com.example.departmentcrud.dto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDto create(DepartmentRequestDto requestDto);
    List<DepartmentResponseDto> findAll();
    DepartmentResponseDto findById(Long id);
    DepartmentResponseDto update(Long id, DepartmentRequestDto requestDto);
    void delete(Long id);
}
