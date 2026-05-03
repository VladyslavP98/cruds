package com.example.employeecrud.service;

import com.example.employeecrud.dto.EmployeeRequestDto;
import com.example.employeecrud.dto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDto create(EmployeeRequestDto requestDto);
    List<EmployeeResponseDto> findAll();
    EmployeeResponseDto findById(Long id);
    EmployeeResponseDto update(Long id, EmployeeRequestDto requestDto);
    void delete(Long id);
}
