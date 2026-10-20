package com.collectiverse.collectiverse.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.collectiverse.collectiverse.dominio.entity.Publication;


public interface RepoPublication extends JpaRepository<Publication, Integer> {
}