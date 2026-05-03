package com.example.devicecrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DeviceRequestDto {
    @NotBlank @Size(max = 120)
    private String model;
    @NotBlank @Size(max = 60)
    private String serialNumber;
    @NotBlank @Size(max = 40)
    private String state;
}
