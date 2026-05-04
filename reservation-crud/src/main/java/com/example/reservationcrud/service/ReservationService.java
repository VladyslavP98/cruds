package com.example.reservationcrud.service;

import com.example.reservationcrud.dto.ReservationRequestDto;
import com.example.reservationcrud.dto.ReservationResponseDto;

import java.util.List;

public interface ReservationService {
    ReservationResponseDto create(ReservationRequestDto requestDto);
    List<ReservationResponseDto> findAll();
    ReservationResponseDto findById(Long id);
    ReservationResponseDto update(Long id, ReservationRequestDto requestDto);
    void delete(Long id);
}
