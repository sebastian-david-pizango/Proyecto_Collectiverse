package com.collectiverse.collectiverse.cu.category;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.collectiverse.collectiverse.dominio.entity.Category;

/** Endpoints del caso de uso para Category. */
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryUseCase useCase;
    public CategoryController(CategoryUseCase useCase) { this.useCase = useCase; }

    @GetMapping
    public List<Category> listar() { return useCase.listar(); }

    @GetMapping("/{id}")
    public Category consultar(@PathVariable Integer id) { return useCase.consultar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category registrar(@RequestBody Category entity) { return useCase.registrar(entity); }
}
