package com.recyclehub.controllers;

import com.recyclehub.models.Desafio;
import com.recyclehub.services.DesafioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/desafios")
public class DesafioController {

    @Autowired
    private DesafioService desafioService;

    @GetMapping
    public String listarDesafios(Model model) {
        model.addAttribute("desafios", desafioService.obtenerTodos());
        return "desafios/lista";
    }

    @GetMapping("/{id}")
    public String verDesafio(@PathVariable Long id, Model model) {
        Optional<Desafio> desafio = desafioService.obtenerPorId(id);
        if (desafio.isPresent()) {
            model.addAttribute("desafio", desafio.get());
            return "desafios/detalle";
        }
        return "redirect:/desafios";
    }

    @PostMapping("/guardar")
    public String guardarDesafio(Desafio desafio) {
        desafioService.guardar(desafio);
        return "redirect:/desafios";
    }

    @PostMapping("/{id}/completar")
    public String completarDesafio(@PathVariable Long id) {
        Optional<Desafio> desafio = desafioService.obtenerPorId(id);
        if (desafio.isPresent()) {
            Desafio d = desafio.get();
            d.setCompletado(true);
            desafioService.guardar(d);
        }
        return "redirect:/desafios";
    }
}
