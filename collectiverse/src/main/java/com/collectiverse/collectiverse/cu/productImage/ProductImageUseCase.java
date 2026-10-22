package com.collectiverse.collectiverse.cu.productImage;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.collectiverse.collectiverse.dominio.entity.ProductImage;
import com.collectiverse.collectiverse.dominio.repository.RepoProductImage;

/** Caso de uso: consultar y registrar ProductImage. */
@Service
public class ProductImageUseCase {
    private final RepoProductImage repository;

    public ProductImageUseCase(RepoProductImage repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<ProductImage> listar() { return repository.findAll(); }

    @Transactional(readOnly = true)
    public ProductImage consultar(Integer id) { return repository.findById(id).orElse(null); }

    @Transactional
    public ProductImage registrar(ProductImage entity) {
        if (entity == null) return null;
        entity.setId(null);
        return repository.save(entity);
    }
}
