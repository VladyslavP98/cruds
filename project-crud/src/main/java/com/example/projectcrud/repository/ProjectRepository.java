package com.example.projectcrud.repository;

import com.example.projectcrud.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {}
