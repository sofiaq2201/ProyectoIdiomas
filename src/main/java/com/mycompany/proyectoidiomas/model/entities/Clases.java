package com.mycompany.proyectoidiomas.model.entities;


import java.time.LocalDate;
import java.util.Date;

public class Clases {
    private int id;
    private Profesores profesor;
    private Alumnos alumno;
    private LocalDate fecha;
    private String horario;
    private EstadosClases estado;
    private Idiomas idioma;
    //lo que hizo franco
    private Disponibilidad dispo;
    
    public Clases(){
    }
    
    public Clases(Disponibilidad reserva, Alumnos alumno){
        this.setHorario(reserva.getHorario());
        this.setFecha(reserva.getFecha());
        this.setProfesor(reserva.getIdProf());
        this.setEstado(new EstadosClases(2, "Reservado"));
        this.setAlumno(alumno);
        //lo que hizo franco
        this.setDispo(reserva);
    }
    
    public String toString() {
    return "clase: {" +
        "Horario: " + this.getHorario()+
        "fecha: " + this.getFecha().toString() + 
        "idProfe: " + this.getProfesor().getId() +
    "}";
}
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstadosClases getEstado() {
        return estado;
    }

    public void setEstado(EstadosClases estado) {
        this.estado = estado;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Idiomas getIdioma() {
        return idioma;
    }

    public void setIdioma(Idiomas idioma) {
        this.idioma = idioma;
    }

    public Disponibilidad getDispo() {
        return dispo;
    }

    public void setDispo(Disponibilidad dispo) {
        this.dispo = dispo;
    }
    
    
}
