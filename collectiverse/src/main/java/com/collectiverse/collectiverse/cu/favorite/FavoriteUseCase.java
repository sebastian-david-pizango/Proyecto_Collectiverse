package com.collectiverse.collectiverse.cu.favorite;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.collectiverse.collectiverse.dominio.entity.Favorite;
import com.collectiverse.collectiverse.dominio.repository.RepoFavorite;

/** Caso de uso: consultar y registrar Favorite. */
@Service
public class FavoriteUseCase {
    private final RepoFavorite repository;

    public FavoriteUseCase(RepoFavorite repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Favorite> listar() { return repository.findAll(); }

    @Transactional(readOnly = true)
    public Favorite consultar(Integer id) { return repository.findById(id).orElse(null); }

    @Transactional
    public Favorite registrar(Favorite entity) {
        if (entity == null) return null;
        entity.setId(null);
        return repository.save(entity);
    }
}
