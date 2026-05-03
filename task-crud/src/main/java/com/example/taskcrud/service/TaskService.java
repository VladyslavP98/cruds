package com.example.taskcrud.service;

import com.example.taskcrud.dto.TaskRequestDto;
import com.example.taskcrud.dto.TaskResponseDto;

import java.util.List;

public interface TaskService {
    TaskResponseDto create(TaskRequestDto requestDto);
    List<TaskResponseDto> findAll();
    TaskResponseDto findById(Long id);
    TaskResponseDto update(Long id, TaskRequestDto requestDto);
    void delete(Long id);
}
