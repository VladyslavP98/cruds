package com.example.vendorcrud.service.impl;

import com.example.vendorcrud.dto.VendorRequestDto;
import com.example.vendorcrud.dto.VendorResponseDto;
import com.example.vendorcrud.entity.Vendor;
import com.example.vendorcrud.exception.ResourceNotFoundException;
import com.example.vendorcrud.repository.VendorRepository;
import com.example.vendorcrud.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {
    private final VendorRepository repository;

    public VendorServiceImpl(VendorRepository repository) { this.repository = repository; }

    public VendorResponseDto create(VendorRequestDto requestDto) {
        Vendor e = new Vendor();
        e.setCompanyName(requestDto.getCompanyName());
        e.setContactPerson(requestDto.getContactPerson());
        e.setStatus(requestDto.getStatus());
        Vendor s = repository.save(e);
        return new VendorResponseDto(s.getId(), s.getCompanyName(), s.getContactPerson(), s.getStatus());
    }

    public List<VendorResponseDto> findAll() {
        return repository.findAll().stream().map(e -> new VendorResponseDto(e.getId(), e.getCompanyName(), e.getContactPerson(), e.getStatus())).toList();
    }

    public VendorResponseDto findById(Long id) {
        Vendor e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vendor not found with id: " + id));
        return new VendorResponseDto(e.getId(), e.getCompanyName(), e.getContactPerson(), e.getStatus());
    }

    public VendorResponseDto update(Long id, VendorRequestDto requestDto) {
        Vendor e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vendor not found with id: " + id));
        e.setCompanyName(requestDto.getCompanyName());
        e.setContactPerson(requestDto.getContactPerson());
        e.setStatus(requestDto.getStatus());
        Vendor s = repository.save(e);
        return new VendorResponseDto(s.getId(), s.getCompanyName(), s.getContactPerson(), s.getStatus());
    }

    public void delete(Long id) {
        Vendor e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vendor not found with id: " + id));
        repository.delete(e);
    }
}
