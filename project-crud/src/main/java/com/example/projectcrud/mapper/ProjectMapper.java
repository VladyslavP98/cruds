package com.example.projectcrud.mapper;

import com.example.projectcrud.dto.ProjectRequestDto;
import com.example.projectcrud.dto.ProjectResponseDto;
import com.example.projectcrud.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public Project toEntity(ProjectRequestDto dto) {
        Project entity = new Project();
        entity.setName(dto.getName());
        entity.setOwner(dto.getOwner());
        entity.setPhase(dto.getPhase());
        return entity;
    }

    public ProjectResponseDto toDto(Project entity) {
        return new ProjectResponseDto(entity.getId(), entity.getName(), entity.getOwner(), entity.getPhase());
    }
}
