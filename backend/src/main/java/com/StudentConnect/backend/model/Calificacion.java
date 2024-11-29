package com.StudentConnect.backend.model;

public class Calificacion {

    private int id;              // ID de la calificación
    private int estudianteId;    // ID del estudiante 
    private int asignaturaId;    // ID de la asignatura 
    private double calificacion; // valor de la calificación
    private String comentario;   // comentario sobre la calificación
    private boolean aprobado;    // Indica si el estudiante está aprobado 

    
    // consteuctores
    public Calificacion() {
        id = -1;
        estudianteId = -1;
        asignaturaId = -1;
        calificacion = -1.00;
        comentario = "default";
        aprobado = false;
    }

    public Calificacion(int id, int estudianteId, int asignaturaId, double calificacion, String comentario) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.asignaturaId = asignaturaId;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.aprobado = calcularAprobado(); // Determina automáticamente si está aprobado
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
    public double getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
        this.aprobado = calcularAprobado(); // Actualiza el estado de aprobado
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public boolean isAprobado() {
        return aprobado;
    }

    // aprobado > = 5
    private boolean calcularAprobado() {
        return this.calificacion >= 5.0;
    }

    // Método toString (para depuración)
    @Override
    public String toString() {
        return "Calificacion{id=" + id + ", estudianteId=" + estudianteId + ", asignaturaId=" + asignaturaId +
               ", calificacion=" + calificacion + ", comentario='" + comentario + "', aprobado=" + aprobado + "}";
    }
}
