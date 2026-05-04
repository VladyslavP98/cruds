package com.example.libraryitemcrud.controller;

import com.example.libraryitemcrud.dto.LibraryItemRequestDto;
import com.example.libraryitemcrud.dto.LibraryItemResponseDto;
import com.example.libraryitemcrud.service.LibraryItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library-items")
public class LibraryItemController {
    private final LibraryItemService service;

    public LibraryItemController(LibraryItemService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LibraryItemResponseDto create(@Valid @RequestBody LibraryItemRequestDto dto) { return service.create(dto); }

    @GetMapping
    public List<LibraryItemResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public LibraryItemResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public LibraryItemResponseDto update(@PathVariable Long id, @Valid @RequestBody LibraryItemRequestDto dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
