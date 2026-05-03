package com.example.categorycrud.service;

import com.example.categorycrud.dto.CategoryRequestDto;
import com.example.categorycrud.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto create(CategoryRequestDto requestDto);
    List<CategoryResponseDto> findAll();
    CategoryResponseDto findById(Long id);
    CategoryResponseDto update(Long id, CategoryRequestDto requestDto);
    void delete(Long id);
}
