package com.example.studentcrud.service.impl;

import com.example.studentcrud.dto.StudentRequestDto;
import com.example.studentcrud.dto.StudentResponseDto;
import com.example.studentcrud.entity.Student;
import com.example.studentcrud.exception.ResourceNotFoundException;
import com.example.studentcrud.repository.StudentRepository;
import com.example.studentcrud.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentResponseDto create(StudentRequestDto requestDto) {
        Student student = toEntity(requestDto);
        Student saved = repository.save(student);
        return toResponseDto(saved);
    }

    @Override
    public List<StudentResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    public StudentResponseDto findById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return toResponseDto(student);
    }

    @Override
    public StudentResponseDto update(Long id, StudentRequestDto requestDto) {
        Student existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        existing.setFullName(requestDto.getFullName());
        existing.setEmail(requestDto.getEmail());
        existing.setAge(requestDto.getAge());

        Student updated = repository.save(existing);
        return toResponseDto(updated);
    }

    @Override
    public void delete(Long id) {
        Student existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        repository.delete(existing);
    }

    private Student toEntity(StudentRequestDto dto) {
        Student student = new Student();
        student.setFullName(dto.getFullName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());
        return student;
    }

    private StudentResponseDto toResponseDto(Student student) {
        return new StudentResponseDto(
                student.getId(),
                student.getFullName(),
                student.getEmail(),
                student.getAge()
        );
    }
}
