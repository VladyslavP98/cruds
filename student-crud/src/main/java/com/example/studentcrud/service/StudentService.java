package com.example.studentcrud.service;

import com.example.studentcrud.dto.StudentRequestDto;
import com.example.studentcrud.dto.StudentResponseDto;

import java.util.List;

public interface StudentService {

    StudentResponseDto create(StudentRequestDto requestDto);

    List<StudentResponseDto> findAll();

    StudentResponseDto findById(Long id);

    StudentResponseDto update(Long id, StudentRequestDto requestDto);

    void delete(Long id);
}
