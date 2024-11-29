package com.StudentConnect.backend.service;

import com.StudentConnect.backend.model.*;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppService {

    private static final String FILE_PATH = "src/main/resources/database.json"; // Ruta al archivo JSON

    // Usuarios
    public List<Usuario> getAllUsuarios() {
        return getData("usuarios", Usuario.class);
    }

    public void saveUsuario(Usuario usuario) {
        saveData("usuarios", usuario);
    }

    public void updateUsuario(Usuario usuario) {
        updateData("usuarios", usuario);
    }

    // Centros
    public List<Centro> getAllCentros() {
        return getData("centros", Centro.class);
    }

    public void saveCentro(Centro centro) {
        saveData("centros", centro);
    }

    public void updateCentro(Centro centro) {
        updateData("centros", centro);
    }

    // Asignaturas
    public List<Asignatura> getAllAsignaturas() {
        return getData("asignaturas", Asignatura.class);
    }

    public void saveAsignatura(Asignatura asignatura) {
        saveData("asignaturas", asignatura);
    }

    public void updateAsignatura(Asignatura asignatura) {
        updateData("asignaturas", asignatura);
    }

    // Asistencias
    public List<Asistencia> getAllAsistencias() {
        return getData("asistencias", Asistencia.class);
    }

    public void saveAsistencia(Asistencia asistencia) {
        saveData("asistencias", asistencia);
    }

    public void updateAsistencia(Asistencia asistencia) {
        updateData("asistencias", asistencia);
    }

    // Calificaciones
    public List<Calificacion> getAllCalificaciones() {
        return getData("calificaciones", Calificacion.class);
    }

    public void saveCalificacion(Calificacion calificacion) {
        saveData("calificaciones", calificacion);
    }

    public void updateCalificacion(Calificacion calificacion) {
        updateData("calificaciones", calificacion);
    }

    // Métodos auxiliares para leer, guardar y actualizar datos

    private <T> List<T> getData(String arrayName, Class<T> clazz) {
        List<T> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            while ((reader.readLine()) != null) {
                // Parse JSON usando una librería como Jackson o Gson
                // Suponemos que la estructura JSON es correcta y tiene la propiedad 'arrayName'
                // Aquí deberías usar un parseo adecuado con Jackson o Gson para mapear el JSON a la clase
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    private <T> void saveData(String arrayName, T data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            // Convierte el objeto a JSON (usando Jackson o Gson)
            // Añade el JSON al archivo correspondiente
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> void updateData(String arrayName, T data) {
        List<T> dataList = getData(arrayName, (Class<T>) data.getClass());
        // Busca el objeto en la lista, actualízalo y guarda el archivo actualizado
        writeData(arrayName, dataList);
    }

    private <T> void writeData(String arrayName, List<T> dataList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            // Convierte la lista a JSON y sobrescribe el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
