package com.StudentConnect.backend.model;

public class Asistencia {

    private int id;
    private int estudianteId;   // ID del estudiante 
    private int asignaturaId;   // ID de la asignatura 
    private String fecha;       // Fecha de la asistencia
    private String estado;      // Estado: "presente", "ausente", etc.

    // constructor
    public Asistencia() {
        id = -1;
        estudianteId = -1;
        asignaturaId = -1;
        fecha = "default";
        estado = "default";
    }

    public Asistencia(int id, int estudianteId, int asignaturaId, String fecha, String estado) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.asignaturaId = asignaturaId;
        this.fecha = fecha;
        this.estado = estado;
    }

    // getters y Setters
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

    @Override
    public String toString() {
        return "Asistencia{id=" + id + ", estudianteId=" + estudianteId + ", asignaturaId=" + asignaturaId + ", fecha='" + fecha + "', estado='" + estado + "'}";
    }
}
