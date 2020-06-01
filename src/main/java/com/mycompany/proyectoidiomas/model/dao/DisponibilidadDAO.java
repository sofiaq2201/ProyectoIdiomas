package com.mycompany.proyectoidiomas.model.dao;

import com.mycompany.proyectoidiomas.model.entities.Disponibilidad;
import com.mycompany.proyectoidiomas.model.entities.Profesores;
import com.mycompany.proyectoidiomas.utils.ConnectionManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DisponibilidadDAO {
    public ArrayList<Disponibilidad> getDisponibilidad (int idProfesor){
     
        ArrayList<Disponibilidad> listaDisponible = new ArrayList<>();
        
        try{
            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
                        
            Statement stm;
            ResultSet rs;
            String sql;
            //lo que hizo franco, estado = 1
            sql = "SELECT * FROM disponibilidad WHERE dispo_id_profe = " + idProfesor +
                    " AND estado = 1 ORDER BY dispo_fecha";
            
            stm = con.createStatement();
            rs = stm.executeQuery( sql );
            
            while( rs.next() ){
               
                Disponibilidad disponibilidad = new Disponibilidad();
                
                disponibilidad.setId(rs.getInt("id_disponibilidad"));
                
                Profesores prof = new Profesores();
                prof.setId(rs.getInt("dispo_id_profe"));
                disponibilidad.setIdProf(prof);
                
                disponibilidad.setFecha(rs.getDate("dispo_fecha").toLocalDate());
                disponibilidad.setHorario(rs.getString("dispo_horario"));
                
                listaDisponible.add(disponibilidad);
                
            }
         
              stm.close();
              rs.close();
              con.close();
            } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Error al obtener el listado disponibilidad");
            }
        return listaDisponible;
    
    }
    
    public void guardarNuevaFecha(Disponibilidad nuevaFecha){
         try{
            ConnectionManager connectionManager = new ConnectionManager();
            
            Connection con = connectionManager.getConnection();
                        
            PreparedStatement stm;
            String sql;
            sql = "INSERT INTO disponibilidad(dispo_id_profe, dispo_fecha,dispo_horario)VALUES (?,?,?)";
            
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, nuevaFecha.getIdProf().getId());
            stm.setDate(2,java.sql.Date.valueOf(nuevaFecha.getFecha()));
            
            stm.setString(3, nuevaFecha.getHorario());
            
            stm.executeUpdate();
             
            stm.close();
            con.close();
         } catch (SQLException ex) {
            System.out.println("Error al registrar nueva fecha y horario");
        }
    }

    public void updateFecha(Disponibilidad editarFecha){
         try{
            ConnectionManager connectionManager = new ConnectionManager();
            
            Connection con = connectionManager.getConnection();
                        
            PreparedStatement stm;
            String sql;
            sql = "UPDATE disponibilidad SET dispo_fecha=(?), dispo_horario=(?) WHERE id_disponibilidad = (?)";
            
            stm = con.prepareStatement(sql);
            
            
            stm.setDate(1,java.sql.Date.valueOf(editarFecha.getFecha()));
            stm.setString(2, editarFecha.getHorario());
            stm.setInt(3, editarFecha.getId());
            
            stm.executeUpdate();
             
            stm.close();
            con.close();
         } catch (SQLException ex) {
            System.out.println("Error al actualizar nueva fecha y horario");
        }
    }
    
    public void deleteFecha(int idFecha){
         try{
            ConnectionManager connectionManager = new ConnectionManager();
            
            Connection con = connectionManager.getConnection();
                        
            PreparedStatement stm = null;
            String sql;
            sql = "UPDATE disponibilidad SET estado = 0 WHERE id_disponibilidad = " + idFecha ;
           
            
            stm = con.prepareStatement(sql);
            
            stm.executeUpdate();
             
            stm.close();
            con.close();
         } catch (SQLException ex) {
            System.out.println("Error al eliminar fecha");
        }
    }
   
    
    public Disponibilidad unaFecha(int idFecha){
       
        Disponibilidad unaFecha = new Disponibilidad();
        try{
            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
                        
            Statement stm;
            ResultSet rs;
            String sql;
            
            sql = "SELECT * FROM disponibilidad WHERE id_disponibilidad = " + idFecha;
            
            stm = con.createStatement();
            rs = stm.executeQuery( sql );
            
                if( rs.next() ){
        
                    unaFecha.setId(rs.getInt("id_disponibilidad"));
                    unaFecha.setFecha(rs.getDate("dispo_fecha").toLocalDate());
                    Profesores prof = new Profesores();
                    prof.setId(rs.getInt("dispo_id_profe"));
                    unaFecha.setIdProf(prof);
                    unaFecha.setHorario(rs.getString("dispo_horario"));
                    
                }
         
              stm.close();
              rs.close();
              con.close();
            } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Error al obtener informacion de la fecha reservada");
            }
        
        return unaFecha;
    }
   
}
