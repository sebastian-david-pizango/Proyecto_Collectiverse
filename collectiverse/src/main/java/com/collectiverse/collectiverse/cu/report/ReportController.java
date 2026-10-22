package com.collectiverse.collectiverse.cu.report;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.collectiverse.collectiverse.dominio.entity.Report;

/** Endpoints del caso de uso para Report. */
@RestController
@RequestMapping("/api/report")
public class ReportController {
    private final ReportUseCase useCase;
    public ReportController(ReportUseCase useCase) { this.useCase = useCase; }

    @GetMapping
    public List<Report> listar() { return useCase.listar(); }

    @GetMapping("/{id}")
    public Report consultar(@PathVariable Integer id) { return useCase.consultar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Report registrar(@RequestBody Report entity) { return useCase.registrar(entity); }
}
