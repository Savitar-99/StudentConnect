package com.StudentConnect.backend.service;

import com.StudentConnect.backend.model.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppService {

    private static final String FILE_PATH = "src/main/resources/database.json"; 
    private final ObjectMapper objectMapper = new ObjectMapper();

    // GETTERS
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            JsonNode rootNode = objectMapper.readTree(reader);
            JsonNode usuariosNode = rootNode.path("usuarios"); 
            if (usuariosNode.isArray()) {
                for (JsonNode node : usuariosNode) {
                    Usuario usuario = objectMapper.treeToValue(node, Usuario.class);
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    public List<Centro> getCentros() {
        List<Centro> centros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            JsonNode rootNode = objectMapper.readTree(reader);
            JsonNode centrosNode = rootNode.path("centros"); // Accedemos al array "centros" en el JSON
            if (centrosNode.isArray()) {
                for (JsonNode node : centrosNode) {
                    Centro centro = objectMapper.treeToValue(node, Centro.class);
                    centros.add(centro);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return centros;
    }
    public List<Asignatura> getAsignaturas() {
        List<Asignatura> asignaturas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            JsonNode rootNode = objectMapper.readTree(reader);
            JsonNode asignaturasNode = rootNode.path("asignaturas"); // Accedemos al array "asignaturas" en el JSON
            if (asignaturasNode.isArray()) {
                for (JsonNode node : asignaturasNode) {
                    Asignatura asignatura = objectMapper.treeToValue(node, Asignatura.class);
                    asignaturas.add(asignatura);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return asignaturas;
    }
    public List<Asistencia> getAsistencias() {
        List<Asistencia> asistencias = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            JsonNode rootNode = objectMapper.readTree(reader);
            JsonNode asistenciasNode = rootNode.path("asistencias"); // Accedemos al array "asistencias" en el JSON
            if (asistenciasNode.isArray()) {
                for (JsonNode node : asistenciasNode) {
                    Asistencia asistencia = objectMapper.treeToValue(node, Asistencia.class);
                    asistencias.add(asistencia);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return asistencias;
    }
    public List<Calificacion> getCalificaciones() {
        List<Calificacion> calificaciones = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            JsonNode rootNode = objectMapper.readTree(reader);
            JsonNode calificacionesNode = rootNode.path("calificaciones"); // Accedemos al array "calificaciones" en el JSON
            if (calificacionesNode.isArray()) {
                for (JsonNode node : calificacionesNode) {
                    Calificacion calificacion = objectMapper.treeToValue(node, Calificacion.class);
                    calificaciones.add(calificacion);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return calificaciones;
    }

    // SAVE AND ADD
    // WRITE OBJ TO JSON
    public void saveData(String arrayName, List<?> dataList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            JsonNode rootNode = objectMapper.readTree(new File(FILE_PATH));
    
            // objetos a json
            JsonNode arrayNode = objectMapper.valueToTree(dataList);
            
            //sustituye en el dbjson
            ((ObjectNode) rootNode).set(arrayName, arrayNode);
            
            // save doc
            objectMapper.writeValue(writer, rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveUsuario(Usuario usuario) {
        List<Usuario> usuarios = getUsuarios();
        usuarios.add(usuario);  
        saveData("usuarios", usuarios);
    }

    public void saveCentro(Centro centro) {
        List<Centro> centros = getCentros();
        centros.add(centro);  
        saveData("centros", centros);
    }

    public void saveAsignatura(Asignatura asignatura) {
        List<Asignatura> asignaturas = getAsignaturas();
        asignaturas.add(asignatura);  
        saveData("asignaturas", asignaturas);
    }

    public void saveAsistencia(Asistencia asistencia) {
        List<Asistencia> asistencias = getAsistencias();
        asistencias.add(asistencia); 
        saveData("asistencias", asistencias);
    }

    public void saveCalificacion(Calificacion calificacion) {
        List<Calificacion> calificaciones = getCalificaciones();
        calificaciones.add(calificacion);  
        saveData("calificaciones", calificaciones);
    }

    

    // UPDATE
    // WRITE OBJ 2 JSON
    public void writeData(String arrayName, List<?> dataList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            JsonNode rootNode = objectMapper.readTree(new File(FILE_PATH));

            // obj 2 json
            JsonNode arrayNode = objectMapper.valueToTree(dataList);
            
            // sustituye 
            ((ObjectNode) rootNode).set(arrayName, arrayNode);

            // save update
            objectMapper.writeValue(writer, rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateUsuario(Usuario usuario) {
        List<Usuario> usuarios = getUsuarios();
        writeData("usuarios", usuarios);
    }

    public void updateCentro(Centro centro) {
        List<Centro> centros = getCentros();
        writeData("centros", centros);
    }

    public void updateAsignatura(Asignatura asignatura) {
        List<Asignatura> asignaturas = getAsignaturas();
        writeData("asignaturas", asignaturas);
    }

    public void updateAsistencia(Asistencia asistencia) {
        List<Asistencia> asistencias = getAsistencias();
        writeData("asistencias", asistencias);
    }

    public void updateCalificacion(Calificacion calificacion) {
        List<Calificacion> calificaciones = getCalificaciones();
        writeData("calificaciones", calificaciones);
    }

    
}
