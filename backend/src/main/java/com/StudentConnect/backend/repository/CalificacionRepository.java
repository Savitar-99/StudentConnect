package com.StudentConnect.backend.repository;

import com.StudentConnect.backend.model.Calificacion;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class CalificacionRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String filePath = "src/main/resources/data/calificaciones.json";

    public List<Calificacion> getAll() {
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<List<Calificacion>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Calificacion> getById(int id) {
        try {
            List<Calificacion> calificaciones = getAll();
            return calificaciones.stream()
                                 .filter(calificacion -> calificacion.getId() == id)  // Usamos "==" para comparar int
                                 .findFirst();
        } catch (Exception e) {  // Captura cualquier excepción general
            e.printStackTrace();
            return Optional.empty();
        }
    }
    

    public void save(Calificacion calificacion) {
        try {
            List<Calificacion> calificaciones = getAll();
            calificaciones.add(calificacion);
            objectMapper.writeValue(new File(filePath), calificaciones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            List<Calificacion> calificaciones = getAll();
            calificaciones.removeIf(calificacion -> calificacion.getId() == id);  // Usamos "==" para comparar int
            objectMapper.writeValue(new File(filePath), calificaciones);  // Guardamos el archivo actualizado
        } catch (Exception e) {  // Captura cualquier excepción general
            e.printStackTrace();
        }
    }
    
}
