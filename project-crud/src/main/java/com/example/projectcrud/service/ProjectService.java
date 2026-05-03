package com.example.projectcrud.service;

import com.example.projectcrud.dto.ProjectRequestDto;
import com.example.projectcrud.dto.ProjectResponseDto;

import java.util.List;

public interface ProjectService {
    ProjectResponseDto create(ProjectRequestDto dto);
    List<ProjectResponseDto> list();
    ProjectResponseDto get(Long id);
    ProjectResponseDto update(Long id, ProjectRequestDto dto);
    void delete(Long id);
}
