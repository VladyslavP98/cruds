package com.example.devicecrud.service.impl;

import com.example.devicecrud.dto.DeviceRequestDto;
import com.example.devicecrud.dto.DeviceResponseDto;
import com.example.devicecrud.entity.Device;
import com.example.devicecrud.exception.ResourceNotFoundException;
import com.example.devicecrud.repository.DeviceRepository;
import com.example.devicecrud.service.DeviceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository repository;
    public DeviceServiceImpl(DeviceRepository repository) { this.repository = repository; }

    public DeviceResponseDto create(DeviceRequestDto requestDto) {
        Device d = new Device(null, requestDto.getModel(), requestDto.getSerialNumber(), requestDto.getState());
        Device saved = repository.save(d);
        return new DeviceResponseDto(saved.getId(), saved.getModel(), saved.getSerialNumber(), saved.getState());
    }

    public List<DeviceResponseDto> getAll() {
        return repository.findAll().stream().map(d -> new DeviceResponseDto(d.getId(), d.getModel(), d.getSerialNumber(), d.getState())).toList();
    }

    public DeviceResponseDto getOne(Long id) {
        Device d = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Device not found with id: " + id));
        return new DeviceResponseDto(d.getId(), d.getModel(), d.getSerialNumber(), d.getState());
    }

    public DeviceResponseDto replace(Long id, DeviceRequestDto requestDto) {
        Device d = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Device not found with id: " + id));
        d.setModel(requestDto.getModel());
        d.setSerialNumber(requestDto.getSerialNumber());
        d.setState(requestDto.getState());
        Device saved = repository.save(d);
        return new DeviceResponseDto(saved.getId(), saved.getModel(), saved.getSerialNumber(), saved.getState());
    }

    public void remove(Long id) {
        Device d = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Device not found with id: " + id));
        repository.delete(d);
    }
}
