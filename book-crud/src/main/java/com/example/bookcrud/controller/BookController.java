package com.example.bookcrud.controller;

import com.example.bookcrud.dto.BookRequestDto;
import com.example.bookcrud.dto.BookResponseDto;
import com.example.bookcrud.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDto create(@Valid @RequestBody BookRequestDto requestDto) { return service.create(requestDto); }

    @GetMapping
    public List<BookResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public BookResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public BookResponseDto update(@PathVariable Long id, @Valid @RequestBody BookRequestDto requestDto) {
        return service.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
