package com.example.contractcrud.controller;

import com.example.contractcrud.dto.ContractRequestDto;
import com.example.contractcrud.dto.ContractResponseDto;
import com.example.contractcrud.service.ContractService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {
    private final ContractService service;

    public ContractController(ContractService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContractResponseDto create(@Valid @RequestBody ContractRequestDto requestDto) { return service.create(requestDto); }

    @GetMapping
    public List<ContractResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ContractResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public ContractResponseDto update(@PathVariable Long id, @Valid @RequestBody ContractRequestDto requestDto) { return service.update(id, requestDto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
