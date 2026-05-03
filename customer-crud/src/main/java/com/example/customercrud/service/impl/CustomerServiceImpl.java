package com.example.customercrud.service.impl;

import com.example.customercrud.dto.CustomerRequestDto;
import com.example.customercrud.dto.CustomerResponseDto;
import com.example.customercrud.entity.Customer;
import com.example.customercrud.exception.ResourceNotFoundException;
import com.example.customercrud.repository.CustomerRepository;
import com.example.customercrud.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerResponseDto create(CustomerRequestDto requestDto) {
        Customer entity = toEntity(requestDto);
        return toResponseDto(repository.save(entity));
    }

    @Override
    public List<CustomerResponseDto> findAll() {
        return repository.findAll().stream().map(this::toResponseDto).toList();
    }

    @Override
    public CustomerResponseDto findById(Long id) {
        Customer entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        return toResponseDto(entity);
    }

    @Override
    public CustomerResponseDto update(Long id, CustomerRequestDto requestDto) {
        Customer entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        entity.setFullName(requestDto.getFullName());
        entity.setEmail(requestDto.getEmail());
        entity.setPhone(requestDto.getPhone());

        return toResponseDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        Customer entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        repository.delete(entity);
    }

    private Customer toEntity(CustomerRequestDto dto) {
        Customer entity = new Customer();
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        return entity;
    }

    private CustomerResponseDto toResponseDto(Customer entity) {
        return new CustomerResponseDto(entity.getId(), entity.getFullName(), entity.getEmail(), entity.getPhone());
    }
}
