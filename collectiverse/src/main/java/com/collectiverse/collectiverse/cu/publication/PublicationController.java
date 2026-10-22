package com.collectiverse.collectiverse.cu.publication;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.collectiverse.collectiverse.dominio.entity.Publication;

/** Endpoints del caso de uso para Publication. */
@RestController
@RequestMapping("/api/publication")
public class PublicationController {
    private final PublicationUseCase useCase;
    public PublicationController(PublicationUseCase useCase) { this.useCase = useCase; }

    @GetMapping
    public List<Publication> listar() { return useCase.listar(); }

    @GetMapping("/{id}")
    public Publication consultar(@PathVariable Integer id) { return useCase.consultar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publication registrar(@RequestBody Publication entity) { return useCase.registrar(entity); }
}
