package com.collectiverse.collectiverse.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.collectiverse.collectiverse.dominio.entity.Categoria;

public interface RepoCategoria extends JpaRepository<Categoria, Integer> {
}


