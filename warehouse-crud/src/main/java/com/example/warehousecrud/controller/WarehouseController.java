package com.example.warehousecrud.controller;

import com.example.warehousecrud.dto.WarehouseRequestDto;
import com.example.warehousecrud.dto.WarehouseResponseDto;
import com.example.warehousecrud.service.WarehouseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {
    private final WarehouseService service;

    public WarehouseController(WarehouseService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WarehouseResponseDto create(@Valid @RequestBody WarehouseRequestDto requestDto) { return service.create(requestDto); }

    @GetMapping
    public List<WarehouseResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public WarehouseResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public WarehouseResponseDto update(@PathVariable Long id, @Valid @RequestBody WarehouseRequestDto requestDto) { return service.update(id, requestDto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
