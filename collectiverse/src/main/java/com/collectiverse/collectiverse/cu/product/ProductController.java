package com.collectiverse.collectiverse.cu.product;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.collectiverse.collectiverse.dominio.entity.Product;

/** Endpoints del caso de uso para Product. */
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductUseCase useCase;
    public ProductController(ProductUseCase useCase) { this.useCase = useCase; }

    @GetMapping
    public List<Product> listar() { return useCase.listar(); }

    @GetMapping("/{id}")
    public Product consultar(@PathVariable Integer id) { return useCase.consultar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product registrar(@RequestBody Product entity) { return useCase.registrar(entity); }
}
