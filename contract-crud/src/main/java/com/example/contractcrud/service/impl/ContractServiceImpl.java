package com.example.contractcrud.service.impl;

import com.example.contractcrud.dto.ContractRequestDto;
import com.example.contractcrud.dto.ContractResponseDto;
import com.example.contractcrud.entity.Contract;
import com.example.contractcrud.exception.ResourceNotFoundException;
import com.example.contractcrud.repository.ContractRepository;
import com.example.contractcrud.service.ContractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    private final ContractRepository repository;

    public ContractServiceImpl(ContractRepository repository) {
        this.repository = repository;
    }

    public ContractResponseDto create(ContractRequestDto requestDto) {
        Contract entity = new Contract();
        entity.setContractNumber(requestDto.getContractNumber());
        entity.setPartnerName(requestDto.getPartnerName());
        entity.setState(requestDto.getState());
        Contract saved = repository.save(entity);
        return new ContractResponseDto(saved.getId(), saved.getContractNumber(), saved.getPartnerName(), saved.getState());
    }

    public List<ContractResponseDto> findAll() {
        return repository.findAll().stream()
                .map(e -> new ContractResponseDto(e.getId(), e.getContractNumber(), e.getPartnerName(), e.getState()))
                .toList();
    }

    public ContractResponseDto findById(Long id) {
        Contract e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contract not found with id: " + id));
        return new ContractResponseDto(e.getId(), e.getContractNumber(), e.getPartnerName(), e.getState());
    }

    public ContractResponseDto update(Long id, ContractRequestDto requestDto) {
        Contract e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contract not found with id: " + id));
        e.setContractNumber(requestDto.getContractNumber());
        e.setPartnerName(requestDto.getPartnerName());
        e.setState(requestDto.getState());
        Contract saved = repository.save(e);
        return new ContractResponseDto(saved.getId(), saved.getContractNumber(), saved.getPartnerName(), saved.getState());
    }

    public void delete(Long id) {
        Contract e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contract not found with id: " + id));
        repository.delete(e);
    }
}
