package com.StudentConnect.backend.model;

public class Asistencia {

    private int id;
    private int estudianteId;   // ID del estudiante (referencia)
    private int asignaturaId;   // ID de la asignatura (referencia)
    private String fecha;       // Fecha de la asistencia
    private String estado;      // Estado: "presente", "ausente", etc.

    // Constructor
    public Asistencia() {}

    public Asistencia(int id, int estudianteId, int asignaturaId, String fecha, String estado) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.asignaturaId = asignaturaId;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public int getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(int asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método toString (para facilitar la depuración)
    @Override
    public String toString() {
        return "Asistencia{id=" + id + ", estudianteId=" + estudianteId + ", asignaturaId=" + asignaturaId + ", fecha='" + fecha + "', estado='" + estado + "'}";
    }
}
