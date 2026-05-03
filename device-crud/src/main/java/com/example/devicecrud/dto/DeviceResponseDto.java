package com.example.devicecrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeviceResponseDto {
    private Long id;
    private String model;
    private String serialNumber;
    private String state;
}
