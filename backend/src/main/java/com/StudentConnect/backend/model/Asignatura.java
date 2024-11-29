package com.StudentConnect.backend.model;

public class Asignatura {

    private int id;
    private String nombre;
    private int profesorId;  // ID del profesor (referencia)
    private int centroId;    // ID del centro (referencia)

    // Constructor
    public Asignatura() {}

    public Asignatura(int id, String nombre, int profesorId, int centroId) {
        this.id = id;
        this.nombre = nombre;
        this.profesorId = profesorId;
        this.centroId = centroId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    public int getCentroId() {
        return centroId;
    }

    public void setCentroId(int centroId) {
        this.centroId = centroId;
    }

    // Método toString (para facilitar la depuración)
    @Override
    public String toString() {
        return "Asignatura{id=" + id + ", nombre='" + nombre + "', profesorId=" + profesorId + ", centroId=" + centroId + '}';
    }
}
