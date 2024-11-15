package com.recyclehub.controllers;

import com.recyclehub.models.RecursoEducativo;
import com.recyclehub.services.RecursoEducativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/recursos")
public class RecursoEducativoController {

    @Autowired
    private RecursoEducativoService recursoEducativoService;

    @GetMapping
    public String listarRecursos(Model model) {
        model.addAttribute("recursos", recursoEducativoService.obtenerTodos());
        return "recursos/lista";  // Página que muestra la lista de recursos
    }

    @GetMapping("/{id}")
    public String verRecurso(@PathVariable Long id, Model model) {
        Optional<RecursoEducativo> recurso = recursoEducativoService.obtenerPorId(id);
        if (recurso.isPresent()) {
            model.addAttribute("recurso", recurso.get());
            return "recursos/detalle";  // Página que muestra los detalles del recurso
        }
        return "redirect:/recursos";  // Redirige a la lista si no se encuentra el recurso
    }

    @PostMapping("/guardar")
    public String guardarRecurso(RecursoEducativo recurso) {
        recursoEducativoService.guardar(recurso);
        return "redirect:/recursos";
    }
}
