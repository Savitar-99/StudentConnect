package com.StudentConnect.backend.service;

import com.StudentConnect.backend.model.Usuario;
import com.StudentConnect.backend.repository.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Definir la ruta al archivo JSON
    private final String USERS_FILE = "src/main/resources/database.json";  

    // Crear una instancia de ObjectMapper
    private ObjectMapper objectMapper = new ObjectMapper();

    //@Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.getAll();
    }

    public Optional<Usuario> getUsuarioById(int id) {
        return usuarioRepository.getById(id);
    }

    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void deleteUsuario(int id) {
        usuarioRepository.delete(id);
    }
    
    public void updateUsuario(Usuario usuario) {
        // Lógica para actualizar un usuario, primero verificar si existe
        Optional<Usuario> existingUsuario = usuarioRepository.getById(usuario.getId());
        if (existingUsuario.isPresent()) {
            usuarioRepository.save(usuario);  // Si existe, se guarda el nuevo valor
        } else {
            // Manejo de error si no existe
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    public Optional<Usuario> getById(int id) {
        List<Usuario> usuarios = loadUsuariosFromJson();  // Cargar los usuarios desde el archivo JSON
        return usuarios.stream()
                .filter(usuario -> usuario.getId() == id)  // Comparar el ID (ahora es un int)
                .findFirst();
    }

    // Método para cargar los usuarios desde el archivo JSON
    public List<Usuario> loadUsuariosFromJson() {
        try {
            // Leemos el archivo JSON y lo deserializamos a una lista de objetos Usuario
            File file = new File(USERS_FILE);
            if (file.exists()) {
                return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Usuario.class));
            } else {
                // Si el archivo no existe, retornamos una lista vacía
                return new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

