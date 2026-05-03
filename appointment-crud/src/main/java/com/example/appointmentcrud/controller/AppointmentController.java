package com.example.appointmentcrud.controller;

import com.example.appointmentcrud.dto.AppointmentRequestDto;
import com.example.appointmentcrud.dto.AppointmentResponseDto;
import com.example.appointmentcrud.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService service;

    public AppointmentController(AppointmentService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponseDto create(@Valid @RequestBody AppointmentRequestDto dto) { return service.create(dto); }

    @GetMapping
    public List<AppointmentResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public AppointmentResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public AppointmentResponseDto update(@PathVariable Long id, @Valid @RequestBody AppointmentRequestDto dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
