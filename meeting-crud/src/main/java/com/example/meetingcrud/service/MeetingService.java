package com.example.meetingcrud.service;

import com.example.meetingcrud.dto.MeetingRequestDto;
import com.example.meetingcrud.dto.MeetingResponseDto;

import java.util.List;

public interface MeetingService {
    MeetingResponseDto create(MeetingRequestDto requestDto);
    List<MeetingResponseDto> findAll();
    MeetingResponseDto findById(Long id);
    MeetingResponseDto update(Long id, MeetingRequestDto requestDto);
    void delete(Long id);
}
