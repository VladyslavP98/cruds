package com.example.ticketcrud.repository;

import com.example.ticketcrud.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {}
