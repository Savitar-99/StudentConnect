package com.StudentConnect.backend.repository;

import com.StudentConnect.backend.model.Usuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String filePath = "src/main/resources/data/usuarios.json";

    public List<Usuario> getAll() {
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<List<Usuario>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Usuario> getById(int id) {
        try {
            List<Usuario> usuarios = getAll();
            return usuarios.stream()
                           .filter(usuario -> usuario.getId() == id)  // Comparar con '==' en lugar de '.equals'
                           .findFirst();
        } catch (Exception e) {  // Usamos una excepción más general si es necesario
            e.printStackTrace();
            return Optional.empty();
        }
    }
    
    

    public void save(Usuario usuario) {
        try {
            List<Usuario> usuarios = getAll();
            usuarios.add(usuario);
            objectMapper.writeValue(new File(filePath), usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            List<Usuario> usuarios = getAll();
            usuarios.removeIf(usuario -> usuario.getId() == id); // Comparación con '==' para primitivos
            objectMapper.writeValue(new File(filePath), usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
