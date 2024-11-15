package com.recyclehub.repositories;

import com.recyclehub.models.Desafio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesafioRepository extends JpaRepository<Desafio, Long> {
    // Métodos personalizados si es necesario
}
