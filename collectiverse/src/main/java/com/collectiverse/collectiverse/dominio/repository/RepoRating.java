package com.collectiverse.collectiverse.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collectiverse.collectiverse.dominio.entity.Rating;

public interface RepoRating extends JpaRepository<Rating, Integer> {
    boolean existsByUserIdAndPublicationId(Integer userId, Integer publicationId);
}