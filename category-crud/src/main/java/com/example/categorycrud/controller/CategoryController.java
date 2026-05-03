package com.example.categorycrud.controller;

import com.example.categorycrud.dto.CategoryRequestDto;
import com.example.categorycrud.dto.CategoryResponseDto;
import com.example.categorycrud.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponseDto create(@Valid @RequestBody CategoryRequestDto requestDto) { return service.create(requestDto); }

    @GetMapping
    public List<CategoryResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public CategoryResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public CategoryResponseDto update(@PathVariable Long id, @Valid @RequestBody CategoryRequestDto requestDto) { return service.update(id, requestDto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
