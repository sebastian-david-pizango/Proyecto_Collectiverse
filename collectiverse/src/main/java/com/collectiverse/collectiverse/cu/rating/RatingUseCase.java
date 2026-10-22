package com.collectiverse.collectiverse.cu.rating;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.collectiverse.collectiverse.dominio.entity.Rating;
import com.collectiverse.collectiverse.dominio.repository.RepoRating;

/** Caso de uso: consultar y registrar Rating. */
@Service
public class RatingUseCase {
    private final RepoRating repository;

    public RatingUseCase(RepoRating repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Rating> listar() { return repository.findAll(); }

    @Transactional(readOnly = true)
    public Rating consultar(Integer id) { return repository.findById(id).orElse(null); }

    @Transactional
    public Rating registrar(Rating entity) {
        if (entity == null) return null;
        entity.setId(null);
        return repository.save(entity);
    }
}
