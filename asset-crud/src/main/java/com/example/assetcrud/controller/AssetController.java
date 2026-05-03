package com.example.assetcrud.controller;

import com.example.assetcrud.dto.AssetRequestDto;
import com.example.assetcrud.dto.AssetResponseDto;
import com.example.assetcrud.service.AssetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssetResponseDto create(@Valid @RequestBody AssetRequestDto requestDto) { return service.create(requestDto); }

    @GetMapping
    public List<AssetResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public AssetResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public AssetResponseDto update(@PathVariable Long id, @Valid @RequestBody AssetRequestDto requestDto) { return service.update(id, requestDto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
