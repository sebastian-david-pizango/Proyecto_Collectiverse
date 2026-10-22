package com.collectiverse.collectiverse.cu.publicationExchange;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.collectiverse.collectiverse.dominio.entity.PublicationExchange;
import com.collectiverse.collectiverse.dominio.repository.RepoPublicationExchange;

/** Caso de uso: consultar y registrar PublicationExchange. */
@Service
public class PublicationExchangeUseCase {
    private final RepoPublicationExchange repository;

    public PublicationExchangeUseCase(RepoPublicationExchange repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<PublicationExchange> listar() { return repository.findAll(); }

    @Transactional(readOnly = true)
    public PublicationExchange consultar(Integer id) { return repository.findById(id).orElse(null); }

    @Transactional
    public PublicationExchange registrar(PublicationExchange entity) {
        if (entity == null) return null;
        entity.setId(null);
        return repository.save(entity);
    }
}
