package com.StudentConnect.backend.service;

import com.StudentConnect.backend.model.Centro;
import com.StudentConnect.backend.repository.CentroRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CentroService {

    private final CentroRepository centroRepository;

    //@Autowired
    public CentroService(CentroRepository centroRepository) {
        this.centroRepository = centroRepository;
    }

    public List<Centro> getAllCentros() {
        return centroRepository.getAll();
    }

    public Optional<Centro> getCentroById(int id) {
        return centroRepository.getById(id);  // Llamada al repositorio para obtener el Centro por su id
    }
    

    public void saveCentro(Centro centro) {
        centroRepository.save(centro);
    }

    public void deleteCentro(int id) {
        centroRepository.delete(id);
    }

    public void updateCentro(Centro centro) {
        // Lógica para actualizar un centro
        Optional<Centro> existingCentro = centroRepository.getById(centro.getId());
        if (existingCentro.isPresent()) {
            centroRepository.save(centro);  // Si existe, se guarda el nuevo valor
        } else {
            // Manejo de error si no existe
            throw new RuntimeException("Centro no encontrado");
        }
    }
}

