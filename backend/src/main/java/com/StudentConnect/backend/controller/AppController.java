package com.StudentConnect.backend.controller;

import com.StudentConnect.backend.model.*;
import com.StudentConnect.backend.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private AppService appService;

    // usuarios
    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return appService.getUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario getUsuarioById(@PathVariable int id) {
        return appService.getUsuarioById(id);
    }

    @PostMapping("/usuarios")
    public void createUsuario(@RequestBody Usuario usuario) {
        appService.saveUsuario(usuario);
    }

    @PutMapping("/usuarios/{id}")
    public void updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        appService.updateUsuario(usuario);
    }

    // centros
    @GetMapping("/centros")
    public List<Centro> getAllCentros() {
        return appService.getCentros();
    }

    @GetMapping("/centros/{id}")
    public Centro getCentroById(@PathVariable int id) {
        return appService.getCentroById(id);
    }

    @PostMapping("/centros")
    public void createCentro(@RequestBody Centro centro) {
        appService.saveCentro(centro);
    }

    @PutMapping("/centros/{id}")
    public void updateCentro(@PathVariable int id, @RequestBody Centro centro) {
        centro.setId(id);
        appService.updateCentro(centro);
    }

    // asignaturas
    @GetMapping("/asignaturas")
    public List<Asignatura> getAllAsignaturas() {
        return appService.getAsignaturas();
    }

    @GetMapping("/asignaturas/{id}")
    public Asignatura getAsignaturaById(@PathVariable int id) {
        return appService.getAsignaturaById(id);
    }

    @PostMapping("/asignaturas")
    public void createAsignatura(@RequestBody Asignatura asignatura) {
        appService.saveAsignatura(asignatura);
    }

    @PutMapping("/asignaturas/{id}")
    public void updateAsignatura(@PathVariable int id, @RequestBody Asignatura asignatura) {
        asignatura.setId(id);
        appService.updateAsignatura(asignatura);
    }

    // asistencias
    @GetMapping("/asistencias")
    public List<Asistencia> getAllAsistencias() {
        return appService.getAsistencias();
    }

    @GetMapping("/asistencias/{id}")
    public Asistencia getAsistenciaById(@PathVariable int id) {
        return appService.getAsistenciaById(id);
    }

    @PostMapping("/asistencias")
    public void createAsistencia(@RequestBody Asistencia asistencia) {
        appService.saveAsistencia(asistencia);
    }

    @PutMapping("/asistencias/{id}")
    public void updateAsistencia(@PathVariable int id, @RequestBody Asistencia asistencia) {
        asistencia.setId(id);
        appService.updateAsistencia(asistencia);
    }

    // calificaciones
    @GetMapping("/calificaciones")
    public List<Calificacion> getAllCalificaciones() {
        return appService.getCalificaciones();
    }

    @GetMapping("/calificaciones/{id}")
    public Calificacion getCalificacionById(@PathVariable int id) {
        return appService.getCalificacionById(id);
    }

    @PostMapping("/calificaciones")
    public void createCalificacion(@RequestBody Calificacion calificacion) {
        appService.saveCalificacion(calificacion);
    }

    @PutMapping("/calificaciones/{id}")
    public void updateCalificacion(@PathVariable int id, @RequestBody Calificacion calificacion) {
        calificacion.setId(id);
        appService.updateCalificacion(calificacion);
    }
}
