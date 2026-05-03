package com.example.devicecrud.repository;

import com.example.devicecrud.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {}
