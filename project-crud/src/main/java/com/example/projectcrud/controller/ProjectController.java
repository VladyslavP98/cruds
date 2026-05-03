package com.example.projectcrud.controller;

import com.example.projectcrud.dto.ProjectRequestDto;
import com.example.projectcrud.dto.ProjectResponseDto;
import com.example.projectcrud.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponseDto create(@Valid @RequestBody ProjectRequestDto dto) { return service.create(dto); }

    @GetMapping
    public List<ProjectResponseDto> list() { return service.list(); }

    @GetMapping("/{id}")
    public ProjectResponseDto get(@PathVariable Long id) { return service.get(id); }

    @PutMapping("/{id}")
    public ProjectResponseDto update(@PathVariable Long id, @Valid @RequestBody ProjectRequestDto dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
