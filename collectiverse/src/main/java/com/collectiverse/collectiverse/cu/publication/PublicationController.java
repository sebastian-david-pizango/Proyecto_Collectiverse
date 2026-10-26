package com.collectiverse.collectiverse.cu.publication;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.collectiverse.collectiverse.cu.publication.request.RequestPublication;
import com.collectiverse.collectiverse.cu.publication.response.ResponsePublication;

/** Endpoints del caso de uso para Publication. */
@RestController
@RequestMapping("/api/publication")
public class PublicationController {

    private final PublicationUseCase useCase;

    public PublicationController(PublicationUseCase useCase) {
        this.useCase = useCase;
    }

    // GET /api/publication -> lista todos
    @GetMapping
    public List<ResponsePublication> listar() {
        return useCase.listar();
    }

    // GET /api/publication/{id} -> consulta uno (404 si no existe)
    @GetMapping("/{id}")
    public ResponsePublication consultar(@PathVariable Integer id) {
        return useCase.consultar(id);
    }

    // POST /api/publication -> registra (@Valid activa las validaciones del Request)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponsePublication registrar(@Valid @RequestBody RequestPublication request, Principal principal) {
        // El usuario sale de la sesión autenticada, no del body
        return useCase.registrar(request, principal.getName());
    }
}
