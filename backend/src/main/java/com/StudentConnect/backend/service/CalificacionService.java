package com.StudentConnect.backend.service;

import com.StudentConnect.backend.model.Calificacion;
import com.StudentConnect.backend.repository.CalificacionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CalificacionService {

    private final CalificacionRepository calificacionRepository;

    //@Autowired
    public CalificacionService(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    public List<Calificacion> getAllCalificaciones() {
        return calificacionRepository.getAll();
    }

    public Optional<Calificacion> getCalificacionById(int id) {
        return calificacionRepository.getById(id);
    }

    public void saveCalificacion(Calificacion calificacion) {
        calificacionRepository.save(calificacion);
    }

    public void deleteCalificacion(int id) {
        calificacionRepository.delete(id);
    }
    
    public void updateCalificacion(Calificacion calificacion) {
        // Lógica para actualizar una calificación
        Optional<Calificacion> existingCalificacion = calificacionRepository.getById(calificacion.getId());
        if (existingCalificacion.isPresent()) {
            calificacionRepository.save(calificacion);  // Si existe, se guarda el nuevo valor
        } else {
            // Manejo de error si no existe
            throw new RuntimeException("Calificación no encontrada");
        }
    }
}
