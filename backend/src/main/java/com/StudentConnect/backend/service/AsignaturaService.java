package com.StudentConnect.backend.service;

import com.StudentConnect.backend.model.Asignatura;
import com.StudentConnect.backend.repository.AsignaturaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    //@Autowired
    public AsignaturaService(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    public List<Asignatura> getAllAsignaturas() {
        return asignaturaRepository.getAll();
    }

    public Optional<Asignatura> getAsignaturaById(int id) {
        return asignaturaRepository.getById(id);
    }

    public void saveAsignatura(Asignatura asignatura) {
        asignaturaRepository.save(asignatura);
    }

    public void deleteAsignatura(int id) {
        asignaturaRepository.delete(id);
    }
    
    public void updateAsignatura(Asignatura asignatura) {
        // Lógica para actualizar una asignatura
        Optional<Asignatura> existingAsignatura = asignaturaRepository.getById(asignatura.getId());
        if (existingAsignatura.isPresent()) {
            asignaturaRepository.save(asignatura);  // Si existe, se guarda el nuevo valor
        } else {
            // Manejo de error si no existe
            throw new RuntimeException("Asignatura no encontrada");
        }
    }
}
