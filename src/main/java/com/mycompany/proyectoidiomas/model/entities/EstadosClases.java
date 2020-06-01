package com.mycompany.proyectoidiomas.model.entities;

public class EstadosClases {
    private int id;
    private String estado;
    
    public EstadosClases(int id, String estado){
        this.id     = id;
        this.estado = estado;
       }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
