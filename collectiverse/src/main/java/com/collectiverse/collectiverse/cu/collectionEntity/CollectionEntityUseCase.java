package com.collectiverse.collectiverse.cu.collectionEntity;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.collectiverse.collectiverse.dominio.entity.CollectionEntity;
import com.collectiverse.collectiverse.dominio.repository.RepoCollection;

/** Caso de uso: consultar y registrar CollectionEntity. */
@Service
public class CollectionEntityUseCase {
    private final RepoCollection repository;

    public CollectionEntityUseCase(RepoCollection repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<CollectionEntity> listar() { return repository.findAll(); }

    @Transactional(readOnly = true)
    public CollectionEntity consultar(Integer id) { return repository.findById(id).orElse(null); }

    @Transactional
    public CollectionEntity registrar(CollectionEntity entity) {
        if (entity == null) return null;
        entity.setId(null);
        return repository.save(entity);
    }
}