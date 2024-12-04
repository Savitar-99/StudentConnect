package com.StudentConnect.backend.repository;

import com.StudentConnect.backend.model.Asignatura;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class AsignaturaRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String filePath = "src/main/resources/data/asignaturas.json";

    public List<Asignatura> getAll() {
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<List<Asignatura>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Asignatura> getById(int id) {
        try {
            List<Asignatura> asignaturas = getAll();
            return asignaturas.stream()
                              .filter(asignatura -> asignatura.getId() == id)  // Usamos "==" para comparar int
                              .findFirst();
        } catch (Exception e) {  // Excepción más general
            e.printStackTrace();
            return Optional.empty();
        }
    }
    

    public void save(Asignatura asignatura) {
        try {
            List<Asignatura> asignaturas = getAll();
            asignaturas.add(asignatura);
            objectMapper.writeValue(new File(filePath), asignaturas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            List<Asignatura> asignaturas = getAll();
            asignaturas.removeIf(asignatura -> asignatura.getId() == id);  // Usamos "==" en lugar de ".equals" para comparar int
            objectMapper.writeValue(new File(filePath), asignaturas);  // Guardamos el archivo actualizado
        } catch (Exception e) {  // Excepción más general
            e.printStackTrace();
        }
    }
    
}
