package com.recyclehub.services;

import com.recyclehub.models.RecursoEducativo;
import com.recyclehub.repositories.RecursoEducativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoEducativoService {

    @Autowired
    private RecursoEducativoRepository recursoEducativoRepository;

    public List<RecursoEducativo> obtenerTodos() {
        return recursoEducativoRepository.findAll();
    }

    public Optional<RecursoEducativo> obtenerPorId(Long id) {
        return recursoEducativoRepository.findById(id);
    }

    public RecursoEducativo guardar(RecursoEducativo recurso) {
        return recursoEducativoRepository.save(recurso);
    }

    public void eliminarPorId(Long id) {
        recursoEducativoRepository.deleteById(id);
    }
}
