package com.example.appointmentcrud.repository;

import com.example.appointmentcrud.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
