package com.StudentConnect.backend.service;

import com.StudentConnect.backend.model.Asistencia;
import com.StudentConnect.backend.repository.AsistenciaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;

    //@Autowired
    public AsistenciaService(AsistenciaRepository asistenciaRepository) {
        this.asistenciaRepository = asistenciaRepository;
    }

    public List<Asistencia> getAllAsistencias() {
        return asistenciaRepository.getAll();
    }

    public Optional<Asistencia> getAsistenciaById(int id) {
        return asistenciaRepository.getById(id);
    }

    public void saveAsistencia(Asistencia asistencia) {
        asistenciaRepository.save(asistencia);
    }

    public void deleteAsistencia(int id) {
        asistenciaRepository.delete(id);
    }

    public void updateAsistencia(Asistencia asistencia) {
        // Lógica para actualizar una asistencia
        Optional<Asistencia> existingAsistencia = asistenciaRepository.getById(asistencia.getId());
        if (existingAsistencia.isPresent()) {
            asistenciaRepository.save(asistencia);  // Si existe, se guarda el nuevo valor
        } else {
            // Manejo de error si no existe
            throw new RuntimeException("Asistencia no encontrada");
        }
    }
}
