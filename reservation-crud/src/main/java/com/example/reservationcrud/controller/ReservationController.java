package com.example.reservationcrud.controller;

import com.example.reservationcrud.dto.ReservationRequestDto;
import com.example.reservationcrud.dto.ReservationResponseDto;
import com.example.reservationcrud.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService service;

    public ReservationController(ReservationService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationResponseDto create(@Valid @RequestBody ReservationRequestDto dto) { return service.create(dto); }

    @GetMapping
    public List<ReservationResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ReservationResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public ReservationResponseDto update(@PathVariable Long id, @Valid @RequestBody ReservationRequestDto dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
