package com.example.shipmentcrud.repository;

import com.example.shipmentcrud.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
