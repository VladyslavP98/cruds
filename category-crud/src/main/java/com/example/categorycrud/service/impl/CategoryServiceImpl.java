package com.example.categorycrud.service.impl;

import com.example.categorycrud.dto.CategoryRequestDto;
import com.example.categorycrud.dto.CategoryResponseDto;
import com.example.categorycrud.entity.Category;
import com.example.categorycrud.exception.ResourceNotFoundException;
import com.example.categorycrud.repository.CategoryRepository;
import com.example.categorycrud.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoryResponseDto create(CategoryRequestDto requestDto) {
        Category entity = toEntity(requestDto);
        return toResponseDto(repository.save(entity));
    }

    @Override
    public List<CategoryResponseDto> findAll() {
        return repository.findAll().stream().map(this::toResponseDto).toList();
    }

    @Override
    public CategoryResponseDto findById(Long id) {
        Category entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        return toResponseDto(entity);
    }

    @Override
    public CategoryResponseDto update(Long id, CategoryRequestDto requestDto) {
        Category entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));

        entity.setName(requestDto.getName());
        entity.setDescription(requestDto.getDescription());
        entity.setCode(requestDto.getCode());
        return toResponseDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        Category entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        repository.delete(entity);
    }

    private Category toEntity(CategoryRequestDto dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setCode(dto.getCode());
        return entity;
    }

    private CategoryResponseDto toResponseDto(Category entity) {
        return new CategoryResponseDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getCode());
    }
}
