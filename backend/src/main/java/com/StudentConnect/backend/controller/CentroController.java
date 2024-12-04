package com.StudentConnect.backend.controller;

import com.StudentConnect.backend.model.Centro;
import com.StudentConnect.backend.service.CentroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/centros")
public class CentroController {

    @Autowired
    private CentroService centroService;

    @GetMapping
    public List<Centro> getAllCentros() {
        return centroService.getAllCentros();
    }

    @PostMapping
    public void addCentro(@RequestBody Centro centro) {
        centroService.saveCentro(centro);
    }

    @PutMapping
    public void updateCentro(@RequestBody Centro centro) {
        centroService.updateCentro(centro);
    }

    @DeleteMapping("/{id}")
    public void deleteCentro(@PathVariable int id) {
        centroService.deleteCentro(id);
    }

    @GetMapping("/{id}")
    public Optional<Centro> getCentroById(@PathVariable int id) {
        return centroService.getById(id);
    }
}
