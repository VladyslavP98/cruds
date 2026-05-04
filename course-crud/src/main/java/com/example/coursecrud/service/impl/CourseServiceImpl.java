package com.example.coursecrud.service.impl;

import com.example.coursecrud.dto.CourseRequestDto;
import com.example.coursecrud.dto.CourseResponseDto;
import com.example.coursecrud.entity.Course;
import com.example.coursecrud.exception.ResourceNotFoundException;
import com.example.coursecrud.repository.CourseRepository;
import com.example.coursecrud.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) { this.repository = repository; }

    public CourseResponseDto create(CourseRequestDto dto) {
        Course e = new Course();
        e.setTitle(dto.getTitle());
        e.setInstructor(dto.getInstructor());
        e.setLevel(dto.getLevel());
        Course s = repository.save(e);
        return new CourseResponseDto(s.getId(), s.getTitle(), s.getInstructor(), s.getLevel());
    }

    public List<CourseResponseDto> findAll() {
        return repository.findAll().stream().map(e -> new CourseResponseDto(e.getId(), e.getTitle(), e.getInstructor(), e.getLevel())).toList();
    }

    public CourseResponseDto findById(Long id) {
        Course e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        return new CourseResponseDto(e.getId(), e.getTitle(), e.getInstructor(), e.getLevel());
    }

    public CourseResponseDto update(Long id, CourseRequestDto dto) {
        Course e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        e.setTitle(dto.getTitle());
        e.setInstructor(dto.getInstructor());
        e.setLevel(dto.getLevel());
        Course s = repository.save(e);
        return new CourseResponseDto(s.getId(), s.getTitle(), s.getInstructor(), s.getLevel());
    }

    public void delete(Long id) {
        Course e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        repository.delete(e);
    }
}
