package com.StudentConnect.backend.repository;

import com.StudentConnect.backend.model.Asistencia;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class AsistenciaRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String filePath = "src/main/resources/data/asistencias.json";

    public List<Asistencia> getAll() {
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<List<Asistencia>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Asistencia> getById(int id) {
        try {
            List<Asistencia> asistencias = getAll();
            return asistencias.stream()
                              .filter(asistencia -> asistencia.getId() == id)  // Usamos "==" para comparar int
                              .findFirst();
        } catch (Exception e) {  // Usamos una excepción más general
            e.printStackTrace();
            return Optional.empty();
        }
    }
    

    public void save(Asistencia asistencia) {
        try {
            List<Asistencia> asistencias = getAll();
            asistencias.add(asistencia);
            objectMapper.writeValue(new File(filePath), asistencias);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            List<Asistencia> asistencias = getAll();
            asistencias.removeIf(asistencia -> asistencia.getId() == id);  // Comparar con "==" en lugar de ".equals"
            objectMapper.writeValue(new File(filePath), asistencias);  // Guardamos el archivo actualizado
        } catch (Exception e) {  // Usamos una excepción más general
            e.printStackTrace();
        }
    }
    
}
