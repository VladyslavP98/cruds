package com.example.ticketcrud.service.impl;

import com.example.ticketcrud.dto.TicketRequestDto;
import com.example.ticketcrud.dto.TicketResponseDto;
import com.example.ticketcrud.entity.Ticket;
import com.example.ticketcrud.exception.ResourceNotFoundException;
import com.example.ticketcrud.mapper.TicketMapper;
import com.example.ticketcrud.repository.TicketRepository;
import com.example.ticketcrud.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository repository;

    public TicketServiceImpl(TicketRepository repository) { this.repository = repository; }

    public TicketResponseDto create(TicketRequestDto request) { return TicketMapper.toDto(repository.save(TicketMapper.toEntity(request))); }

    public List<TicketResponseDto> findAll() { return repository.findAll().stream().map(TicketMapper::toDto).toList(); }

    public TicketResponseDto findById(Long id) { return TicketMapper.toDto(getOrThrow(id)); }

    public TicketResponseDto update(Long id, TicketRequestDto request) {
        Ticket t = getOrThrow(id);
        t.setTitle(request.title());
        t.setPriority(request.priority());
        t.setStatus(request.status());
        return TicketMapper.toDto(repository.save(t));
    }

    public void delete(Long id) { repository.delete(getOrThrow(id)); }

    private Ticket getOrThrow(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + id));
    }
}
