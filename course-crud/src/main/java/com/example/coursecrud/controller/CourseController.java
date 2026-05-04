package com.example.coursecrud.controller;

import com.example.coursecrud.dto.CourseRequestDto;
import com.example.coursecrud.dto.CourseResponseDto;
import com.example.coursecrud.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponseDto create(@Valid @RequestBody CourseRequestDto dto) { return service.create(dto); }

    @GetMapping
    public List<CourseResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public CourseResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public CourseResponseDto update(@PathVariable Long id, @Valid @RequestBody CourseRequestDto dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
