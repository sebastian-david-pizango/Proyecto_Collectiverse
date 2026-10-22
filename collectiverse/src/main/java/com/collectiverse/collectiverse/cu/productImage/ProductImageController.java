package com.collectiverse.collectiverse.cu.productImage;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.collectiverse.collectiverse.dominio.entity.ProductImage;

/** Endpoints del caso de uso para ProductImage. */
@RestController
@RequestMapping("/api/product-image")
public class ProductImageController {
    private final ProductImageUseCase useCase;
    public ProductImageController(ProductImageUseCase useCase) { this.useCase = useCase; }

    @GetMapping
    public List<ProductImage> listar() { return useCase.listar(); }

    @GetMapping("/{id}")
    public ProductImage consultar(@PathVariable Integer id) { return useCase.consultar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductImage registrar(@RequestBody ProductImage entity) { return useCase.registrar(entity); }
}
