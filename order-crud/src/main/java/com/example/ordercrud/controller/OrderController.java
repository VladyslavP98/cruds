package com.example.ordercrud.controller;

import com.example.ordercrud.dto.OrderRequestDto;
import com.example.ordercrud.dto.OrderResponseDto;
import com.example.ordercrud.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDto create(@Valid @RequestBody OrderRequestDto requestDto) {
        return service.create(requestDto);
    }

    @GetMapping
    public List<OrderResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public OrderResponseDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public OrderResponseDto update(@PathVariable Long id, @Valid @RequestBody OrderRequestDto requestDto) {
        return service.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
