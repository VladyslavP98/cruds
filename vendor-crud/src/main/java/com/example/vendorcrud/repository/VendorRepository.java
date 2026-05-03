package com.example.vendorcrud.repository;

import com.example.vendorcrud.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
