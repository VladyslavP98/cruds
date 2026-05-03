package com.example.contractcrud.service;

import com.example.contractcrud.dto.ContractRequestDto;
import com.example.contractcrud.dto.ContractResponseDto;

import java.util.List;

public interface ContractService {
    ContractResponseDto create(ContractRequestDto requestDto);
    List<ContractResponseDto> findAll();
    ContractResponseDto findById(Long id);
    ContractResponseDto update(Long id, ContractRequestDto requestDto);
    void delete(Long id);
}
