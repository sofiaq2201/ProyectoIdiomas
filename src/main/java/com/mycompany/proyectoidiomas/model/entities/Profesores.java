package com.mycompany.proyectoidiomas.model.entities;

public class Profesores {
  private int id;
    private String email;
    private String nombre;
    private String password; 
    private Idiomas idioma;
    private String rol;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
    
    public Idiomas getIdioma(){
        return idioma;
    }
    
    public void setIdioma(Idiomas idioma){
        this.idioma = idioma;
    }
    
    public String getRol(){
        return rol;
    }
    public void setRol(){
        this.rol = "Profesor";
    }
    
}
