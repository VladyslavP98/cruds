package com.example.bookcrud.service.impl;

import com.example.bookcrud.dto.BookRequestDto;
import com.example.bookcrud.dto.BookResponseDto;
import com.example.bookcrud.entity.Book;
import com.example.bookcrud.exception.ResourceNotFoundException;
import com.example.bookcrud.repository.BookRepository;
import com.example.bookcrud.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookResponseDto create(BookRequestDto requestDto) {
        Book entity = toEntity(requestDto);
        return toResponseDto(repository.save(entity));
    }

    @Override
    public List<BookResponseDto> findAll() {
        return repository.findAll().stream().map(this::toResponseDto).toList();
    }

    @Override
    public BookResponseDto findById(Long id) {
        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        return toResponseDto(entity);
    }

    @Override
    public BookResponseDto update(Long id, BookRequestDto requestDto) {
        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        entity.setFullName(requestDto.getFullName());
        entity.setEmail(requestDto.getEmail());
        entity.setPhone(requestDto.getPhone());

        return toResponseDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        repository.delete(entity);
    }

    private Book toEntity(BookRequestDto dto) {
        Book entity = new Book();
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        return entity;
    }

    private BookResponseDto toResponseDto(Book entity) {
        return new BookResponseDto(entity.getId(), entity.getFullName(), entity.getEmail(), entity.getPhone());
    }
}
