package com.example.ordercrud.service;

import com.example.ordercrud.dto.OrderRequestDto;
import com.example.ordercrud.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {

    OrderResponseDto create(OrderRequestDto requestDto);

    List<OrderResponseDto> findAll();

    OrderResponseDto findById(Long id);

    OrderResponseDto update(Long id, OrderRequestDto requestDto);

    void delete(Long id);
}
