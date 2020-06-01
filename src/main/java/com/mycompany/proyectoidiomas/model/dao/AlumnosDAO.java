package com.mycompany.proyectoidiomas.model.dao;

import com.mycompany.proyectoidiomas.model.entities.Alumnos;
import com.mycompany.proyectoidiomas.utils.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlumnosDAO {
    
     public ArrayList<Alumnos> getListadoDeAlumnos(){
        //TODOS los alumnos existentes
        ArrayList<Alumnos> listadoAlumnos = new ArrayList<>();  
      
         try{
            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
                        
            Statement stm;
            ResultSet rs;
            String sql;
            
            sql = "SELECT * from alumnos";
            stm = con.createStatement();
            rs = stm.executeQuery( sql );
                       
            while(rs.next()){
                
                Alumnos alumno = new Alumnos();
                //declaro set los valores traidos get de la bd
                alumno.setId( rs.getInt("id_alum") );
                alumno.setEmail(rs.getString("alum_email"));
                alumno.setNombre(rs.getString("alum_nombre"));
                alumno.setPassword(rs.getString("alum_password"));
                alumno.setRol();
                
                //System.out.print(alumno.getEmail());
                //System.out.print(alumno.getNombre());
                listadoAlumnos.add(alumno);
            }
            stm.close();
            rs.close();
            con.close();
             } catch (SQLException ex) {
            System.out.println("Error al obtener el listado de alumnos");
        }
        
        return listadoAlumnos;
        
     }
     
     public ArrayList<Alumnos> getAlumnosDelProfesor(int idProf){
         //Listado de Alumnos del profesor
         ArrayList<Alumnos> listadoAlumnos = new ArrayList<>();  
      
         try{
            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
                        
            Statement stm;
            ResultSet rs;
            String sql;
            sql = "SELECT DISTINCT(alum_email), alum_nombre " +
               " FROM clases, alumnos "+
               " WHERE clases.clase_alumno_id = id_alum AND clases.clase_profe_id = " + idProf; 
            stm = con.createStatement();
            rs = stm.executeQuery( sql );
            
             while(rs.next()){
                   Alumnos alumno = new Alumnos();
                   alumno.setEmail(rs.getString("alum_email"));
                   alumno.setNombre(rs.getString("alum_nombre"));
                   
                   listadoAlumnos.add(alumno);
             }
         } catch (SQLException ex) {
            System.out.println("Error al obtener el listado de alumnos del profesor");
        }
         return listadoAlumnos;
     
     }
     
     public void guardarAlumno(Alumnos alumno){
     
         try{
            ConnectionManager connectionManager = new ConnectionManager();
            
            Connection con = connectionManager.getConnection();
                        
            PreparedStatement stm;
            String sql;
            sql = "INSERT INTO alumnos (alum_email,alum_nombre,alum_password) VALUES (?,?,?)";
            
            stm = con.prepareStatement(sql);
            
            stm.setString(1, alumno.getEmail());
            stm.setString(2, alumno.getNombre());
            stm.setString(3, alumno.getPassword());
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
         } catch (SQLException ex) {
            System.out.println("Error al registrar alumno");
        }
         
     
     }
     
    public Alumnos getUserAlumno(String email){
        
        Alumnos alumno = new Alumnos();
        try{
        ConnectionManager connectionManager = new ConnectionManager();
        Connection con = connectionManager.getConnection();
        Statement stm;
        ResultSet rs;
        String sql;
            
        sql = "SELECT * FROM alumnos WHERE alum_email = '" + email+"'";
        stm = con.prepareStatement(sql);
        
        
        rs= stm.executeQuery(sql);
        if(rs.next() ){
            alumno.setEmail(rs.getString("alum_email"));
            alumno.setId(rs.getInt("id_alum"));
            alumno.setNombre(rs.getString("alum_nombre"));
            alumno.setRol();
            alumno.setPassword(rs.getString("alum_password"));
        }
        }catch (SQLException ex) {
            System.out.println("Error al obtener alumno");
        }
        
         
         
         return alumno;
     }
}
     

