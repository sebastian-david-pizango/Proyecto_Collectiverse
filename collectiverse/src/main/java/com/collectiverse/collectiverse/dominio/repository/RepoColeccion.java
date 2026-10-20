package com.collectiverse.collectiverse.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.collectiverse.collectiverse.dominio.entity.Coleccion;


public interface RepoColeccion extends JpaRepository<Coleccion, Integer> {
}
