package com.example.reservationcrud.repository;

import com.example.reservationcrud.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {}
