package com.collectiverse.collectiverse.cu.collectionEntity;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.collectiverse.collectiverse.dominio.entity.CollectionEntity;

/** Endpoints del caso de uso para CollectionEntity. */
@RestController
@RequestMapping("/api/collection")
public class CollectionEntityController {
    private final CollectionEntityUseCase useCase;
    public CollectionEntityController(CollectionEntityUseCase useCase) { this.useCase = useCase; }

    @GetMapping
    public List<CollectionEntity> listar() { return useCase.listar(); }

    @GetMapping("/{id}")
    public CollectionEntity consultar(@PathVariable Integer id) { return useCase.consultar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CollectionEntity registrar(@RequestBody CollectionEntity entity) { return useCase.registrar(entity); }
}
