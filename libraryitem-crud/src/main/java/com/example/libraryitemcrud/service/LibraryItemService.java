package com.example.libraryitemcrud.service;

import com.example.libraryitemcrud.dto.LibraryItemRequestDto;
import com.example.libraryitemcrud.dto.LibraryItemResponseDto;

import java.util.List;

public interface LibraryItemService {
    LibraryItemResponseDto create(LibraryItemRequestDto requestDto);
    List<LibraryItemResponseDto> findAll();
    LibraryItemResponseDto findById(Long id);
    LibraryItemResponseDto update(Long id, LibraryItemRequestDto requestDto);
    void delete(Long id);
}
