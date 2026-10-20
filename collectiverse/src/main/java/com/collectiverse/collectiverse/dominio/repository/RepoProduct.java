package com.collectiverse.collectiverse.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collectiverse.collectiverse.dominio.entity.Product;

public interface RepoProduct extends JpaRepository<Product, Integer> {
}