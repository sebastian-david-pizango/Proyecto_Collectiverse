package com.collectiverse.collectiverse.cu.favorite;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.collectiverse.collectiverse.dominio.entity.Favorite;

/** Endpoints del caso de uso para Favorite. */
@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {
    private final FavoriteUseCase useCase;
    public FavoriteController(FavoriteUseCase useCase) { this.useCase = useCase; }

    @GetMapping
    public List<Favorite> listar() { return useCase.listar(); }

    @GetMapping("/{id}")
    public Favorite consultar(@PathVariable Integer id) { return useCase.consultar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Favorite registrar(@RequestBody Favorite entity) { return useCase.registrar(entity); }
}
