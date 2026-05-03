package com.example.departmentcrud.controller;

import com.example.departmentcrud.dto.DepartmentRequestDto;
import com.example.departmentcrud.dto.DepartmentResponseDto;
import com.example.departmentcrud.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentResponseDto create(@Valid @RequestBody DepartmentRequestDto requestDto) { return service.create(requestDto); }

    @GetMapping
    public List<DepartmentResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public DepartmentResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public DepartmentResponseDto update(@PathVariable Long id, @Valid @RequestBody DepartmentRequestDto requestDto) { return service.update(id, requestDto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
