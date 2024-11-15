package com.recyclehub.services;

import com.recyclehub.models.Desafio;
import com.recyclehub.repositories.DesafioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesafioService {

    @Autowired
    private DesafioRepository desafioRepository;

    public List<Desafio> obtenerTodos() {
        return desafioRepository.findAll();
    }

    public Optional<Desafio> obtenerPorId(Long id) {
        return desafioRepository.findById(id);
    }

    public Desafio guardar(Desafio desafio) {
        return desafioRepository.save(desafio);
    }

    public void eliminarPorId(Long id) {
        desafioRepository.deleteById(id);
    }
}
