package com.example.assetcrud.service.impl;

import com.example.assetcrud.dto.AssetRequestDto;
import com.example.assetcrud.dto.AssetResponseDto;
import com.example.assetcrud.entity.Asset;
import com.example.assetcrud.exception.ResourceNotFoundException;
import com.example.assetcrud.repository.AssetRepository;
import com.example.assetcrud.service.AssetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {
    private final AssetRepository repository;

    public AssetServiceImpl(AssetRepository repository) {
        this.repository = repository;
    }

    public AssetResponseDto create(AssetRequestDto requestDto) {
        Asset entity = new Asset();
        entity.setAssetName(requestDto.getAssetName());
        entity.setAssetType(requestDto.getAssetType());
        entity.setCondition(requestDto.getCondition());
        Asset saved = repository.save(entity);
        return new AssetResponseDto(saved.getId(), saved.getAssetName(), saved.getAssetType(), saved.getCondition());
    }

    public List<AssetResponseDto> findAll() {
        return repository.findAll().stream()
                .map(e -> new AssetResponseDto(e.getId(), e.getAssetName(), e.getAssetType(), e.getCondition()))
                .toList();
    }

    public AssetResponseDto findById(Long id) {
        Asset e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Asset not found with id: " + id));
        return new AssetResponseDto(e.getId(), e.getAssetName(), e.getAssetType(), e.getCondition());
    }

    public AssetResponseDto update(Long id, AssetRequestDto requestDto) {
        Asset e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Asset not found with id: " + id));
        e.setAssetName(requestDto.getAssetName());
        e.setAssetType(requestDto.getAssetType());
        e.setCondition(requestDto.getCondition());
        Asset saved = repository.save(e);
        return new AssetResponseDto(saved.getId(), saved.getAssetName(), saved.getAssetType(), saved.getCondition());
    }

    public void delete(Long id) {
        Asset e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Asset not found with id: " + id));
        repository.delete(e);
    }
}
