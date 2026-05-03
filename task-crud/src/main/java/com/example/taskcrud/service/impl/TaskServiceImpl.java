package com.example.taskcrud.service.impl;

import com.example.taskcrud.dto.TaskRequestDto;
import com.example.taskcrud.dto.TaskResponseDto;
import com.example.taskcrud.entity.Task;
import com.example.taskcrud.exception.ResourceNotFoundException;
import com.example.taskcrud.repository.TaskRepository;
import com.example.taskcrud.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) { this.repository = repository; }

    public TaskResponseDto create(TaskRequestDto requestDto) {
        Task e = new Task();
        e.setTitle(requestDto.getTitle());
        e.setAssignee(requestDto.getAssignee());
        e.setProgress(requestDto.getProgress());
        Task s = repository.save(e);
        return new TaskResponseDto(s.getId(), s.getTitle(), s.getAssignee(), s.getProgress());
    }

    public List<TaskResponseDto> findAll() {
        return repository.findAll().stream().map(e -> new TaskResponseDto(e.getId(), e.getTitle(), e.getAssignee(), e.getProgress())).toList();
    }

    public TaskResponseDto findById(Long id) {
        Task e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        return new TaskResponseDto(e.getId(), e.getTitle(), e.getAssignee(), e.getProgress());
    }

    public TaskResponseDto update(Long id, TaskRequestDto requestDto) {
        Task e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        e.setTitle(requestDto.getTitle());
        e.setAssignee(requestDto.getAssignee());
        e.setProgress(requestDto.getProgress());
        Task s = repository.save(e);
        return new TaskResponseDto(s.getId(), s.getTitle(), s.getAssignee(), s.getProgress());
    }

    public void delete(Long id) {
        Task e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        repository.delete(e);
    }
}
