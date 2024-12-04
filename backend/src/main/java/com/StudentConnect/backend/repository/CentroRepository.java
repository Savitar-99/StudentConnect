package com.StudentConnect.backend.repository;

import com.StudentConnect.backend.model.Centro;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class CentroRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String filePath = "src/main/resources/data/centros.json";

    public List<Centro> getAll() {
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<List<Centro>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Centro> getById(int id) {
        try {
            List<Centro> centros = getAll();
            return centros.stream().filter(centro -> centro.getId() == id).findFirst();  // Comparar con "==" en lugar de ".equals"
        } catch (Exception e) {  // Usamos una excepción más general si es necesario
            e.printStackTrace();
            return Optional.empty();
        }
    }
    
    

    public void save(Centro centro) {
        try {
            List<Centro> centros = getAll();
            centros.add(centro);
            objectMapper.writeValue(new File(filePath), centros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            List<Centro> centros = getAll();
            centros.removeIf(centro -> centro.getId() == id);  // Comparar con "==" en lugar de ".equals"
            objectMapper.writeValue(new File(filePath), centros);
        } catch (Exception e) {  // Usamos una excepción más general si es necesario
            e.printStackTrace();
        }
    }
    
}
