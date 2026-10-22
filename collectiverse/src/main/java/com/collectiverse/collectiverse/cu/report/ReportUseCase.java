package com.collectiverse.collectiverse.cu.report;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.collectiverse.collectiverse.dominio.entity.Report;
import com.collectiverse.collectiverse.dominio.repository.RepoReport;

/** Caso de uso: consultar y registrar Report. */
@Service
public class ReportUseCase {
    private final RepoReport repository;

    public ReportUseCase(RepoReport repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Report> listar() { return repository.findAll(); }

    @Transactional(readOnly = true)
    public Report consultar(Integer id) { return repository.findById(id).orElse(null); }

    @Transactional
    public Report registrar(Report entity) {
        if (entity == null) return null;
        entity.setId(null);
        return repository.save(entity);
    }
}
