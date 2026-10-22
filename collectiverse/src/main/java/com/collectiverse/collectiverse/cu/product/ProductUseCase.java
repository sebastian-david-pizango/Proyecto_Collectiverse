package com.collectiverse.collectiverse.cu.product;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.collectiverse.collectiverse.dominio.entity.Product;
import com.collectiverse.collectiverse.dominio.repository.RepoProduct;

/** Caso de uso: consultar y registrar Product. */
@Service
public class ProductUseCase {
    private final RepoProduct repository;

    public ProductUseCase(RepoProduct repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Product> listar() { return repository.findAll(); }

    @Transactional(readOnly = true)
    public Product consultar(Integer id) { return repository.findById(id).orElse(null); }

    @Transactional
    public Product registrar(Product entity) {
        if (entity == null) return null;
        entity.setId(null);
        return repository.save(entity);
    }
}
