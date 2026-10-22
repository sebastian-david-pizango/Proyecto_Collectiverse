package com.collectiverse.collectiverse.cu.rating;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.collectiverse.collectiverse.dominio.entity.Rating;

/** Endpoints del caso de uso para Rating. */
@RestController
@RequestMapping("/api/rating")
public class RatingController {
    private final RatingUseCase useCase;
    public RatingController(RatingUseCase useCase) { this.useCase = useCase; }

    @GetMapping
    public List<Rating> listar() { return useCase.listar(); }

    @GetMapping("/{id}")
    public Rating consultar(@PathVariable Integer id) { return useCase.consultar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rating registrar(@RequestBody Rating entity) { return useCase.registrar(entity); }
}
