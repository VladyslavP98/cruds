package com.example.ticketcrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TicketRequestDto(
        @NotBlank @Size(max = 140) String title,
        @NotBlank @Size(max = 40) String priority,
        @NotBlank @Size(max = 40) String status
) {}
