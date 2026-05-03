package com.example.appointmentcrud.service.impl;

import com.example.appointmentcrud.dto.AppointmentRequestDto;
import com.example.appointmentcrud.dto.AppointmentResponseDto;
import com.example.appointmentcrud.entity.Appointment;
import com.example.appointmentcrud.exception.ResourceNotFoundException;
import com.example.appointmentcrud.repository.AppointmentRepository;
import com.example.appointmentcrud.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repository;

    public AppointmentServiceImpl(AppointmentRepository repository) { this.repository = repository; }

    public AppointmentResponseDto create(AppointmentRequestDto requestDto) {
        Appointment e = new Appointment();
        e.setSubject(requestDto.getSubject());
        e.setAttendee(requestDto.getAttendee());
        e.setType(requestDto.getType());
        Appointment s = repository.save(e);
        return new AppointmentResponseDto(s.getId(), s.getSubject(), s.getAttendee(), s.getType());
    }

    public List<AppointmentResponseDto> findAll() {
        return repository.findAll().stream().map(e -> new AppointmentResponseDto(e.getId(), e.getSubject(), e.getAttendee(), e.getType())).toList();
    }

    public AppointmentResponseDto findById(Long id) {
        Appointment e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));
        return new AppointmentResponseDto(e.getId(), e.getSubject(), e.getAttendee(), e.getType());
    }

    public AppointmentResponseDto update(Long id, AppointmentRequestDto requestDto) {
        Appointment e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));
        e.setSubject(requestDto.getSubject());
        e.setAttendee(requestDto.getAttendee());
        e.setType(requestDto.getType());
        Appointment s = repository.save(e);
        return new AppointmentResponseDto(s.getId(), s.getSubject(), s.getAttendee(), s.getType());
    }

    public void delete(Long id) {
        Appointment e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));
        repository.delete(e);
    }
}
