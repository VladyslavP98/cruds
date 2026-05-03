package com.example.appointmentcrud.service;

import com.example.appointmentcrud.dto.AppointmentRequestDto;
import com.example.appointmentcrud.dto.AppointmentResponseDto;

import java.util.List;

public interface AppointmentService {
    AppointmentResponseDto create(AppointmentRequestDto requestDto);
    List<AppointmentResponseDto> findAll();
    AppointmentResponseDto findById(Long id);
    AppointmentResponseDto update(Long id, AppointmentRequestDto requestDto);
    void delete(Long id);
}
