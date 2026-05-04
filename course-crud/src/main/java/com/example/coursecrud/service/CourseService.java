package com.example.coursecrud.service;

import com.example.coursecrud.dto.CourseRequestDto;
import com.example.coursecrud.dto.CourseResponseDto;

import java.util.List;

public interface CourseService {
    CourseResponseDto create(CourseRequestDto requestDto);
    List<CourseResponseDto> findAll();
    CourseResponseDto findById(Long id);
    CourseResponseDto update(Long id, CourseRequestDto requestDto);
    void delete(Long id);
}
