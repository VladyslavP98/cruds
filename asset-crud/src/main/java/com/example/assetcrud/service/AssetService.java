package com.example.assetcrud.service;

import com.example.assetcrud.dto.AssetRequestDto;
import com.example.assetcrud.dto.AssetResponseDto;

import java.util.List;

public interface AssetService {
    AssetResponseDto create(AssetRequestDto requestDto);
    List<AssetResponseDto> findAll();
    AssetResponseDto findById(Long id);
    AssetResponseDto update(Long id, AssetRequestDto requestDto);
    void delete(Long id);
}
