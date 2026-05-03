package com.example.projectcrud.service.impl;

import com.example.projectcrud.dto.ProjectRequestDto;
import com.example.projectcrud.dto.ProjectResponseDto;
import com.example.projectcrud.entity.Project;
import com.example.projectcrud.exception.ResourceNotFoundException;
import com.example.projectcrud.mapper.ProjectMapper;
import com.example.projectcrud.repository.ProjectRepository;
import com.example.projectcrud.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;
    private final ProjectMapper mapper;

    public ProjectServiceImpl(ProjectRepository repository, ProjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProjectResponseDto create(ProjectRequestDto dto) { return mapper.toDto(repository.save(mapper.toEntity(dto))); }

    public List<ProjectResponseDto> list() { return repository.findAll().stream().map(mapper::toDto).toList(); }

    public ProjectResponseDto get(Long id) { return mapper.toDto(fetch(id)); }

    public ProjectResponseDto update(Long id, ProjectRequestDto dto) {
        Project p = fetch(id);
        p.setName(dto.getName());
        p.setOwner(dto.getOwner());
        p.setPhase(dto.getPhase());
        return mapper.toDto(repository.save(p));
    }

    public void delete(Long id) { repository.delete(fetch(id)); }

    private Project fetch(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
    }
}
