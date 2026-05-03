package com.example.bookcrud.service;

import com.example.bookcrud.dto.BookRequestDto;
import com.example.bookcrud.dto.BookResponseDto;

import java.util.List;

public interface BookService {
    BookResponseDto create(BookRequestDto requestDto);
    List<BookResponseDto> findAll();
    BookResponseDto findById(Long id);
    BookResponseDto update(Long id, BookRequestDto requestDto);
    void delete(Long id);
}
