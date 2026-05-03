package com.example.devicecrud.controller;

import com.example.devicecrud.dto.DeviceRequestDto;
import com.example.devicecrud.dto.DeviceResponseDto;
import com.example.devicecrud.service.DeviceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    private final DeviceService service;
    public DeviceController(DeviceService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceResponseDto create(@Valid @RequestBody DeviceRequestDto dto) { return service.create(dto); }

    @GetMapping
    public List<DeviceResponseDto> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public DeviceResponseDto getOne(@PathVariable Long id) { return service.getOne(id); }

    @PutMapping("/{id}")
    public DeviceResponseDto replace(@PathVariable Long id, @Valid @RequestBody DeviceRequestDto dto) { return service.replace(id, dto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) { service.remove(id); }
}
