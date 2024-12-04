package com.StudentConnect.backend.controller;

import com.StudentConnect.backend.model.Usuario;
import com.StudentConnect.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @PostMapping
    public void addUsuario(@RequestBody Usuario usuario) {
        usuarioService.saveUsuario(usuario);
    }

    @PutMapping
    public void updateUsuario(@RequestBody Usuario usuario) {
        usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable int id) {
        usuarioService.deleteUsuario(id);
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable int id) {
        return usuarioService.getById(id);
    }
}
