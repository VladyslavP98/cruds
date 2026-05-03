package com.example.vendorcrud.controller;

import com.example.vendorcrud.dto.VendorRequestDto;
import com.example.vendorcrud.dto.VendorResponseDto;
import com.example.vendorcrud.service.VendorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {
    private final VendorService service;

    public VendorController(VendorService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorResponseDto create(@Valid @RequestBody VendorRequestDto dto) { return service.create(dto); }

    @GetMapping
    public List<VendorResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public VendorResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public VendorResponseDto update(@PathVariable Long id, @Valid @RequestBody VendorRequestDto dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
