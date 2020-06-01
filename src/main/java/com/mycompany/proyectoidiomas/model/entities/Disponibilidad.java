package com.mycompany.proyectoidiomas.model.entities;

import java.time.LocalDate;
import java.util.Date;

public class Disponibilidad {
    private int Id;
    private Profesores idProf;
    private LocalDate fecha;
    private String horario;
    //lo que hizo franco
    private boolean estado;
    
    public  Disponibilidad(){
        
    }
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Profesores getIdProf() {
        return idProf;
    }

    public void setIdProf(Profesores idProf) {
        this.idProf = idProf;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    //lo que hizo franco
    public boolean isEstado() {
        return estado;
    }
    //lo que hizo franco
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
   
    
}
