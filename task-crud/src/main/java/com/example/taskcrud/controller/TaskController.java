package com.example.taskcrud.controller;

import com.example.taskcrud.dto.TaskRequestDto;
import com.example.taskcrud.dto.TaskResponseDto;
import com.example.taskcrud.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponseDto create(@Valid @RequestBody TaskRequestDto dto) { return service.create(dto); }

    @GetMapping
    public List<TaskResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public TaskResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public TaskResponseDto update(@PathVariable Long id, @Valid @RequestBody TaskRequestDto dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
