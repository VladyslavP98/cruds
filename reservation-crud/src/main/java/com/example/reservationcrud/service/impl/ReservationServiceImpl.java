package com.example.reservationcrud.service.impl;

import com.example.reservationcrud.dto.ReservationRequestDto;
import com.example.reservationcrud.dto.ReservationResponseDto;
import com.example.reservationcrud.entity.Reservation;
import com.example.reservationcrud.exception.ResourceNotFoundException;
import com.example.reservationcrud.repository.ReservationRepository;
import com.example.reservationcrud.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository repository;

    public ReservationServiceImpl(ReservationRepository repository) { this.repository = repository; }

    public ReservationResponseDto create(ReservationRequestDto dto) {
        Reservation e = new Reservation();
        e.setReservedBy(dto.getReservedBy());
        e.setResourceName(dto.getResourceName());
        e.setStatus(dto.getStatus());
        Reservation s = repository.save(e);
        return new ReservationResponseDto(s.getId(), s.getReservedBy(), s.getResourceName(), s.getStatus());
    }

    public List<ReservationResponseDto> findAll() {
        return repository.findAll().stream().map(e -> new ReservationResponseDto(e.getId(), e.getReservedBy(), e.getResourceName(), e.getStatus())).toList();
    }

    public ReservationResponseDto findById(Long id) {
        Reservation e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
        return new ReservationResponseDto(e.getId(), e.getReservedBy(), e.getResourceName(), e.getStatus());
    }

    public ReservationResponseDto update(Long id, ReservationRequestDto dto) {
        Reservation e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
        e.setReservedBy(dto.getReservedBy());
        e.setResourceName(dto.getResourceName());
        e.setStatus(dto.getStatus());
        Reservation s = repository.save(e);
        return new ReservationResponseDto(s.getId(), s.getReservedBy(), s.getResourceName(), s.getStatus());
    }

    public void delete(Long id) {
        Reservation e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
        repository.delete(e);
    }
}
