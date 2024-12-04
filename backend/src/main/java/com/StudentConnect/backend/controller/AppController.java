package com.StudentConnect.backend.controller;

import com.StudentConnect.backend.model.*;
import com.StudentConnect.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private CentroService centroService;
    
    @Autowired
    private AsignaturaService asignaturaService;
    
    @Autowired
    private AsistenciaService asistenciaService;
    
    @Autowired
    private CalificacionService calificacionService;

    // Métodos para Usuarios
    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @PostMapping("/usuarios")
    public void addUsuario(@RequestBody Usuario usuario) {
        usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/usuarios")
    public void updateUsuario(@RequestBody Usuario usuario) {
        usuarioService.updateUsuario(usuario);
    }

    // Métodos para Centros
    @GetMapping("/centros")
    public List<Centro> getAllCentros() {
        return centroService.getAllCentros();
    }

    @PostMapping("/centros")
    public void addCentro(@RequestBody Centro centro) {
        centroService.saveCentro(centro);
    }

    @PutMapping("/centros")
    public void updateCentro(@RequestBody Centro centro) {
        centroService.updateCentro(centro);
    }

    // Métodos para Asignaturas
    @GetMapping("/asignaturas")
    public List<Asignatura> getAllAsignaturas() {
        return asignaturaService.getAllAsignaturas();
    }

    @PostMapping("/asignaturas")
    public void addAsignatura(@RequestBody Asignatura asignatura) {
        asignaturaService.saveAsignatura(asignatura);
    }

    @PutMapping("/asignaturas")
    public void updateAsignatura(@RequestBody Asignatura asignatura) {
        asignaturaService.updateAsignatura(asignatura);
    }

    // Métodos para Asistencias
    @GetMapping("/asistencias")
    public List<Asistencia> getAllAsistencias() {
        return asistenciaService.getAllAsistencias();
    }

    @PostMapping("/asistencias")
    public void addAsistencia(@RequestBody Asistencia asistencia) {
        asistenciaService.saveAsistencia(asistencia);
    }

    @PutMapping("/asistencias")
    public void updateAsistencia(@RequestBody Asistencia asistencia) {
        asistenciaService.updateAsistencia(asistencia);
    }

    // Métodos para Calificaciones
    @GetMapping("/calificaciones")
    public List<Calificacion> getAllCalificaciones() {
        return calificacionService.getAllCalificaciones();
    }

    @PostMapping("/calificaciones")
    public void addCalificacion(@RequestBody Calificacion calificacion) {
        calificacionService.saveCalificacion(calificacion);
    }

    @PutMapping("/calificaciones")
    public void updateCalificacion(@RequestBody Calificacion calificacion) {
        calificacionService.updateCalificacion(calificacion);
    }
}
