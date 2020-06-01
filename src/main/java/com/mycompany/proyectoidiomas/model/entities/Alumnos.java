package com.mycompany.proyectoidiomas.model.entities;

public class Alumnos {
    private int id;
    private String email;
    private String nombre;
    private String password; 
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
    
  public String getRol(){
        return rol;
    }
    public void setRol(){
        this.rol = "Estudiante";
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    
    
}
