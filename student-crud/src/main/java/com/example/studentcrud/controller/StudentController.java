package com.example.studentcrud.controller;

import com.example.studentcrud.dto.StudentRequestDto;
import com.example.studentcrud.dto.StudentResponseDto;
import com.example.studentcrud.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDto create(@Valid @RequestBody StudentRequestDto requestDto) {
        return service.create(requestDto);
    }

    @GetMapping
    public List<StudentResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public StudentResponseDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDto update(@PathVariable Long id, @Valid @RequestBody StudentRequestDto requestDto) {
        return service.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
