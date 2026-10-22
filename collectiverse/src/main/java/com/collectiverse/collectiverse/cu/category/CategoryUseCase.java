package com.collectiverse.collectiverse.cu.category;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.collectiverse.collectiverse.dominio.entity.Category;
import com.collectiverse.collectiverse.dominio.repository.RepoCategory;

/** Caso de uso: consultar y registrar Category. */
@Service
public class CategoryUseCase {
    private final RepoCategory repository;

    public CategoryUseCase(RepoCategory repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Category> listar() { return repository.findAll(); }

    @Transactional(readOnly = true)
    public Category consultar(Integer id) { return repository.findById(id).orElse(null); }

    @Transactional
    public Category registrar(Category entity) {
        if (entity == null) return null;
        entity.setId(null);
        return repository.save(entity);
    }
}
