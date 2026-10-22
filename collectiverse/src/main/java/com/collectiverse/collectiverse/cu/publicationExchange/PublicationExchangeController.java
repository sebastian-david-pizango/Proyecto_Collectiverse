package com.collectiverse.collectiverse.cu.publicationExchange;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.collectiverse.collectiverse.dominio.entity.PublicationExchange;

/** Endpoints del caso de uso para PublicationExchange. */
@RestController
@RequestMapping("/api/publication-exchange")
public class PublicationExchangeController {
    private final PublicationExchangeUseCase useCase;
    public PublicationExchangeController(PublicationExchangeUseCase useCase) { this.useCase = useCase; }

    @GetMapping
    public List<PublicationExchange> listar() { return useCase.listar(); }

    @GetMapping("/{id}")
    public PublicationExchange consultar(@PathVariable Integer id) { return useCase.consultar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublicationExchange registrar(@RequestBody PublicationExchange entity) { return useCase.registrar(entity); }
}
