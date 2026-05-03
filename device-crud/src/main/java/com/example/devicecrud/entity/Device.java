package com.example.devicecrud.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "devices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 120)
    private String model;
    @Column(nullable = false, length = 60)
    private String serialNumber;
    @Column(nullable = false, length = 40)
    private String state;
}
