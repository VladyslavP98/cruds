package com.example.ticketcrud.mapper;

import com.example.ticketcrud.dto.TicketRequestDto;
import com.example.ticketcrud.dto.TicketResponseDto;
import com.example.ticketcrud.entity.Ticket;

public final class TicketMapper {
    private TicketMapper() {}

    public static Ticket toEntity(TicketRequestDto dto) {
        Ticket t = new Ticket();
        t.setTitle(dto.title());
        t.setPriority(dto.priority());
        t.setStatus(dto.status());
        return t;
    }

    public static TicketResponseDto toDto(Ticket t) {
        return new TicketResponseDto(t.getId(), t.getTitle(), t.getPriority(), t.getStatus());
    }
}
