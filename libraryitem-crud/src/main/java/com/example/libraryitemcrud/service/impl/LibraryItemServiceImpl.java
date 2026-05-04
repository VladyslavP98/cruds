package com.example.libraryitemcrud.service.impl;

import com.example.libraryitemcrud.dto.LibraryItemRequestDto;
import com.example.libraryitemcrud.dto.LibraryItemResponseDto;
import com.example.libraryitemcrud.entity.LibraryItem;
import com.example.libraryitemcrud.exception.ResourceNotFoundException;
import com.example.libraryitemcrud.repository.LibraryItemRepository;
import com.example.libraryitemcrud.service.LibraryItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryItemServiceImpl implements LibraryItemService {
    private final LibraryItemRepository repository;

    public LibraryItemServiceImpl(LibraryItemRepository repository) { this.repository = repository; }

    public LibraryItemResponseDto create(LibraryItemRequestDto dto) {
        LibraryItem e = new LibraryItem();
        e.setCode(dto.getCode());
        e.setItemType(dto.getItemType());
        e.setState(dto.getState());
        LibraryItem s = repository.save(e);
        return new LibraryItemResponseDto(s.getId(), s.getCode(), s.getItemType(), s.getState());
    }

    public List<LibraryItemResponseDto> findAll() {
        return repository.findAll().stream().map(e -> new LibraryItemResponseDto(e.getId(), e.getCode(), e.getItemType(), e.getState())).toList();
    }

    public LibraryItemResponseDto findById(Long id) {
        LibraryItem e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("LibraryItem not found with id: " + id));
        return new LibraryItemResponseDto(e.getId(), e.getCode(), e.getItemType(), e.getState());
    }

    public LibraryItemResponseDto update(Long id, LibraryItemRequestDto dto) {
        LibraryItem e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("LibraryItem not found with id: " + id));
        e.setCode(dto.getCode());
        e.setItemType(dto.getItemType());
        e.setState(dto.getState());
        LibraryItem s = repository.save(e);
        return new LibraryItemResponseDto(s.getId(), s.getCode(), s.getItemType(), s.getState());
    }

    public void delete(Long id) {
        LibraryItem e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("LibraryItem not found with id: " + id));
        repository.delete(e);
    }
}
