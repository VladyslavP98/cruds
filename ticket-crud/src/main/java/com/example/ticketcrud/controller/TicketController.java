package com.example.ticketcrud.controller;

import com.example.ticketcrud.dto.TicketRequestDto;
import com.example.ticketcrud.dto.TicketResponseDto;
import com.example.ticketcrud.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService service;
    public TicketController(TicketService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketResponseDto create(@Valid @RequestBody TicketRequestDto request) { return service.create(request); }
    @GetMapping
    public List<TicketResponseDto> findAll() { return service.findAll(); }
    @GetMapping("/{id}")
    public TicketResponseDto findById(@PathVariable Long id) { return service.findById(id); }
    @PutMapping("/{id}")
    public TicketResponseDto update(@PathVariable Long id, @Valid @RequestBody TicketRequestDto request) { return service.update(id, request); }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
