package com.collectiverse.collectiverse.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import aQute.bnd.annotation.headers.Category;


public interface RepoCategory extends JpaRepository<Category, Integer> {
}