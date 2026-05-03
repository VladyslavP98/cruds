package com.example.vendorcrud.service;

import com.example.vendorcrud.dto.VendorRequestDto;
import com.example.vendorcrud.dto.VendorResponseDto;

import java.util.List;

public interface VendorService {
    VendorResponseDto create(VendorRequestDto requestDto);
    List<VendorResponseDto> findAll();
    VendorResponseDto findById(Long id);
    VendorResponseDto update(Long id, VendorRequestDto requestDto);
    void delete(Long id);
}
