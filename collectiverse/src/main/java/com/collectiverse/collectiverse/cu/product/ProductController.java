package com.collectiverse.collectiverse.cu.product;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.collectiverse.collectiverse.cu.product.request.RequestProduct;
import com.collectiverse.collectiverse.cu.product.response.ResponseProduct;

/** Endpoints del caso de uso para Product. */
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductUseCase useCase;

    public ProductController(ProductUseCase useCase) {
        this.useCase = useCase;
    }

    // GET /api/product -> lista todos
    @GetMapping
    public List<ResponseProduct> listar() {
        return useCase.listar();
    }

    // GET /api/product/{id} -> consulta uno (404 si no existe)
    @GetMapping("/{id}")
    public ResponseProduct consultar(@PathVariable Integer id) {
        return useCase.consultar(id);
    }

    // POST /api/product -> registra (@Valid activa las validaciones del Request)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseProduct registrar(@Valid @RequestBody RequestProduct request, Principal principal) {
        // El usuario sale de la sesión autenticada, no del body
        return useCase.registrar(request, principal.getName());
    }
}
