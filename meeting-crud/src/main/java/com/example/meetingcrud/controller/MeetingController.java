package com.example.meetingcrud.controller;

import com.example.meetingcrud.dto.MeetingRequestDto;
import com.example.meetingcrud.dto.MeetingResponseDto;
import com.example.meetingcrud.service.MeetingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meetings")
public class MeetingController {
    private final MeetingService service;

    public MeetingController(MeetingService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MeetingResponseDto create(@Valid @RequestBody MeetingRequestDto requestDto) { return service.create(requestDto); }

    @GetMapping
    public List<MeetingResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public MeetingResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public MeetingResponseDto update(@PathVariable Long id, @Valid @RequestBody MeetingRequestDto requestDto) { return service.update(id, requestDto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
