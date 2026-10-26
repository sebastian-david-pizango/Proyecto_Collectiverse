package com.collectiverse.collectiverse.cu.product;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collectiverse.collectiverse.cu.category.exception.CategoryNotFoundException;
import com.collectiverse.collectiverse.cu.collectionEntity.exception.CollectionNotFoundException;
import com.collectiverse.collectiverse.cu.product.exception.ProductNotFoundException;
import com.collectiverse.collectiverse.cu.product.request.RequestProduct;
import com.collectiverse.collectiverse.cu.product.response.ResponseProduct;
import com.collectiverse.collectiverse.dominio.entity.Category;
import com.collectiverse.collectiverse.dominio.entity.CollectionEntity;
import com.collectiverse.collectiverse.dominio.entity.Product;
import com.collectiverse.collectiverse.dominio.repository.RepoCategory;
import com.collectiverse.collectiverse.dominio.repository.RepoCollection;
import com.collectiverse.collectiverse.dominio.repository.RepoProduct;

/** Caso de uso: consultar y registrar Product. */
@Service
public class ProductUseCase {

    private final RepoProduct repository;
    private final RepoCategory repoCategory;
    private final RepoCollection repoCollection;

    public ProductUseCase(RepoProduct repository, RepoCategory repoCategory, RepoCollection repoCollection) {
        this.repository = repository;
        this.repoCategory = repoCategory;
        this.repoCollection = repoCollection;
    }

    @Transactional(readOnly = true)
    public List<ResponseProduct> listar() {
        return repository.findAll().stream().map(this::aResponse).toList();
    }

    @Transactional(readOnly = true)
    public ResponseProduct consultar(Integer id) {
        return aResponse(repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id)));
    }

    @Transactional
    public ResponseProduct registrar(RequestProduct request, String usuario) {
        // La categoría debe existir
        Category category = repoCategory.findById(request.idCategory())
                .orElseThrow(() -> new CategoryNotFoundException(request.idCategory()));
        Product p = new Product();
        p.setCategory(category);
        // La colección es opcional, pero si se envía debe existir
        if (request.idCollection() != null) {
            CollectionEntity collection = repoCollection.findById(request.idCollection())
                    .orElseThrow(() -> new CollectionNotFoundException(request.idCollection()));
            p.setCollection(collection);
        }
        p.setName(request.name());
        p.setStock(request.stock());
        p.setPrice(request.price());
        p.setCreatedBy(usuario);
        return aResponse(repository.save(p));
    }

    // Convierte la entidad en el Response que ve el cliente
    private ResponseProduct aResponse(Product e) {
        return new ResponseProduct(e.getId(), e.getCategory().getId(),
                e.getCollection() != null ? e.getCollection().getId() : null,
                e.getName(), e.getStock(), e.getPrice(), e.getStatus());
    }
}
