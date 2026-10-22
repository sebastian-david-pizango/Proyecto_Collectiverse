package com.collectiverse.collectiverse.cu.publication;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.collectiverse.collectiverse.dominio.entity.Publication;
import com.collectiverse.collectiverse.dominio.repository.RepoPublication;

/** Caso de uso: consultar y registrar Publication. */
@Service
public class PublicationUseCase {
    private final RepoPublication repository;

    public PublicationUseCase(RepoPublication repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Publication> listar() { return repository.findAll(); }

    @Transactional(readOnly = true)
    public Publication consultar(Integer id) { return repository.findById(id).orElse(null); }

    @Transactional
    public Publication registrar(Publication entity) {
        if (entity == null) return null;
        entity.setId(null);
        return repository.save(entity);
    }
}
