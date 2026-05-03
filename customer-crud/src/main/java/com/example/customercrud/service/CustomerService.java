package com.example.customercrud.service;

import com.example.customercrud.dto.CustomerRequestDto;
import com.example.customercrud.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto create(CustomerRequestDto requestDto);
    List<CustomerResponseDto> findAll();
    CustomerResponseDto findById(Long id);
    CustomerResponseDto update(Long id, CustomerRequestDto requestDto);
    void delete(Long id);
}
