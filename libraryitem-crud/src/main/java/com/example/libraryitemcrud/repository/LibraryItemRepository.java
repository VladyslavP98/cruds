package com.example.libraryitemcrud.repository;

import com.example.libraryitemcrud.entity.LibraryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryItemRepository extends JpaRepository<LibraryItem, Long> {}
