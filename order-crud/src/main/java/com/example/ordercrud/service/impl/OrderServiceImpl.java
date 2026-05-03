package com.example.ordercrud.service.impl;

import com.example.ordercrud.dto.OrderRequestDto;
import com.example.ordercrud.dto.OrderResponseDto;
import com.example.ordercrud.entity.Order;
import com.example.ordercrud.exception.ResourceNotFoundException;
import com.example.ordercrud.repository.OrderRepository;
import com.example.ordercrud.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderResponseDto create(OrderRequestDto requestDto) {
        Order order = toEntity(requestDto);
        Order saved = repository.save(order);
        return toResponseDto(saved);
    }

    @Override
    public List<OrderResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    public OrderResponseDto findById(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        return toResponseDto(order);
    }

    @Override
    public OrderResponseDto update(Long id, OrderRequestDto requestDto) {
        Order existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));

        existing.setOrderNumber(requestDto.getOrderNumber());
        existing.setCustomerName(requestDto.getCustomerName());
        existing.setTotalAmount(requestDto.getTotalAmount());

        Order updated = repository.save(existing);
        return toResponseDto(updated);
    }

    @Override
    public void delete(Long id) {
        Order existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        repository.delete(existing);
    }

    private Order toEntity(OrderRequestDto dto) {
        Order order = new Order();
        order.setOrderNumber(dto.getOrderNumber());
        order.setCustomerName(dto.getCustomerName());
        order.setTotalAmount(dto.getTotalAmount());
        return order;
    }

    private OrderResponseDto toResponseDto(Order order) {
        return new OrderResponseDto(
                order.getId(),
                order.getOrderNumber(),
                order.getCustomerName(),
                order.getTotalAmount()
        );
    }
}
