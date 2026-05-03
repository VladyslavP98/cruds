package com.example.shipmentcrud.controller;

import com.example.shipmentcrud.dto.ShipmentRequestDto;
import com.example.shipmentcrud.dto.ShipmentResponseDto;
import com.example.shipmentcrud.service.ShipmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {
    private final ShipmentService service;

    public ShipmentController(ShipmentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShipmentResponseDto create(@Valid @RequestBody ShipmentRequestDto requestDto) { return service.create(requestDto); }

    @GetMapping
    public List<ShipmentResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ShipmentResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public ShipmentResponseDto update(@PathVariable Long id, @Valid @RequestBody ShipmentRequestDto requestDto) { return service.update(id, requestDto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
