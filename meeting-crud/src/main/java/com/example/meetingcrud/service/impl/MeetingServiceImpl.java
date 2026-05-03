package com.example.meetingcrud.service.impl;

import com.example.meetingcrud.dto.MeetingRequestDto;
import com.example.meetingcrud.dto.MeetingResponseDto;
import com.example.meetingcrud.entity.Meeting;
import com.example.meetingcrud.exception.ResourceNotFoundException;
import com.example.meetingcrud.repository.MeetingRepository;
import com.example.meetingcrud.service.MeetingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService {
    private final MeetingRepository repository;

    public MeetingServiceImpl(MeetingRepository repository) {
        this.repository = repository;
    }

    public MeetingResponseDto create(MeetingRequestDto requestDto) {
        Meeting entity = new Meeting();
        entity.setTopic(requestDto.getTopic());
        entity.setOrganizer(requestDto.getOrganizer());
        entity.setFormat(requestDto.getFormat());
        Meeting saved = repository.save(entity);
        return new MeetingResponseDto(saved.getId(), saved.getTopic(), saved.getOrganizer(), saved.getFormat());
    }

    public List<MeetingResponseDto> findAll() {
        return repository.findAll().stream()
                .map(e -> new MeetingResponseDto(e.getId(), e.getTopic(), e.getOrganizer(), e.getFormat()))
                .toList();
    }

    public MeetingResponseDto findById(Long id) {
        Meeting e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Meeting not found with id: " + id));
        return new MeetingResponseDto(e.getId(), e.getTopic(), e.getOrganizer(), e.getFormat());
    }

    public MeetingResponseDto update(Long id, MeetingRequestDto requestDto) {
        Meeting e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Meeting not found with id: " + id));
        e.setTopic(requestDto.getTopic());
        e.setOrganizer(requestDto.getOrganizer());
        e.setFormat(requestDto.getFormat());
        Meeting saved = repository.save(e);
        return new MeetingResponseDto(saved.getId(), saved.getTopic(), saved.getOrganizer(), saved.getFormat());
    }

    public void delete(Long id) {
        Meeting e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Meeting not found with id: " + id));
        repository.delete(e);
    }
}
