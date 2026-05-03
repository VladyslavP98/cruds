package com.example.productcrud.service;

import com.example.productcrud.dto.ProductRequestDto;
import com.example.productcrud.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto create(ProductRequestDto requestDto);

    List<ProductResponseDto> findAll();

    ProductResponseDto findById(Long id);

    ProductResponseDto update(Long id, ProductRequestDto requestDto);

    void delete(Long id);
}
