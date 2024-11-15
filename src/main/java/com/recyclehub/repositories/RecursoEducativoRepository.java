package com.recyclehub.repositories;

import com.recyclehub.models.RecursoEducativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoEducativoRepository extends JpaRepository<RecursoEducativo, Long> {
    // Métodos adicionales de consulta pueden agregarse aquí si es necesario
}
