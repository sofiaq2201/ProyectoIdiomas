package com.mycompany.proyectoidiomas.model.dao;


import com.mycompany.proyectoidiomas.model.entities.Idiomas;
import com.mycompany.proyectoidiomas.model.entities.Profesores;
import com.mycompany.proyectoidiomas.utils.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProfesoresDAO {
    public void guardarProfesor(Profesores profesor){
        
        try{
            ConnectionManager connectionManager = new ConnectionManager();
            
            Connection con = connectionManager.getConnection();
                        
            PreparedStatement stm;
            String sql;
            sql = "INSERT INTO profesores(prof_email,prof_nombre,prof_pass,prof_idioma_id) VALUES (?,?,?,?)";
            
            stm = con.prepareStatement(sql);
            
            stm.setString(1, profesor.getEmail());
            stm.setString(2, profesor.getNombre());
            stm.setString(3, profesor.getPassword());
            stm.setInt(4, profesor.getIdioma().getId());
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
         } catch (SQLException ex) {
            System.out.println("Error al registrar Profesor");
        }
        
    }
    
    public Profesores getUserProf(String email){
        
        Profesores prof = new Profesores();
        try{
        ConnectionManager connectionManager = new ConnectionManager();
        Connection con = connectionManager.getConnection();
        Statement stm;
        ResultSet rs;
        String sql;
            
        sql = "SELECT * FROM profesores WHERE prof_email =  '" + email+"'";
        stm = con.prepareStatement(sql);
        
        
        rs= stm.executeQuery(sql);
        if(rs.next() ){
            prof.setId(rs.getInt("id_prof"));
            prof.setEmail(rs.getString("prof_email"));
            prof.setNombre(rs.getString("prof_nombre"));
            prof.setPassword(rs.getString("prof_pass"));
            prof.setRol();
            Idiomas idioma = new Idiomas();
            idioma.setId(rs.getInt("prof_idioma_id"));
            prof.setIdioma(idioma);
            
           
        }
        
        }catch (SQLException ex) {
            System.out.println("Error al obtener profesor");
            System.out.println(ex);
        }
        
        return prof;
    } 
    
    public ArrayList<Profesores> getProfesores(){
        
        ArrayList<Profesores> listaProfesores = new ArrayList<>();       
        
        try{
            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
                        
            Statement stm;
            ResultSet rs;
            String sql;
            
            sql = "SELECT profesores.id_prof ,profesores.prof_nombre, idiomas.idioma_nombre" + 
                  " FROM profesores, idiomas "+
                  " WHERE prof_idioma_id = idiomas.id_idioma";
            
            stm = con.createStatement();
            rs = stm.executeQuery( sql );
            
            while( rs.next() ){
                Profesores prof = new Profesores();
                
                prof.setId(rs.getInt("id_prof"));
                prof.setNombre(rs.getString("prof_nombre"));
                
                Idiomas idioma = new Idiomas(); 
                idioma.setNombre(rs.getString("idioma_nombre"));
                prof.setIdioma(idioma);
                
                listaProfesores.add(prof);            
         
                }
         
            stm.close();
            rs.close();
            con.close();
            } catch (SQLException ex) {
            System.out.println(ex)    ;
            System.out.println("Error al obtener el listado de profesores");
            }
        
            return listaProfesores;
        }
    
}
