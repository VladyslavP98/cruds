package com.example.devicecrud.service;

import com.example.devicecrud.dto.DeviceRequestDto;
import com.example.devicecrud.dto.DeviceResponseDto;

import java.util.List;

public interface DeviceService {
    DeviceResponseDto create(DeviceRequestDto requestDto);
    List<DeviceResponseDto> getAll();
    DeviceResponseDto getOne(Long id);
    DeviceResponseDto replace(Long id, DeviceRequestDto requestDto);
    void remove(Long id);
}
