package com.example.ticketcrud.service;

import com.example.ticketcrud.dto.TicketRequestDto;
import com.example.ticketcrud.dto.TicketResponseDto;

import java.util.List;

public interface TicketService {
    TicketResponseDto create(TicketRequestDto request);
    List<TicketResponseDto> findAll();
    TicketResponseDto findById(Long id);
    TicketResponseDto update(Long id, TicketRequestDto request);
    void delete(Long id);
}
