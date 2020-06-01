package com.mycompany.proyectoidiomas.model.dao;

import com.mycompany.proyectoidiomas.model.entities.Alumnos;
import com.mycompany.proyectoidiomas.model.entities.Clases;
import com.mycompany.proyectoidiomas.model.entities.EstadosClases;
import com.mycompany.proyectoidiomas.model.entities.Idiomas;
import com.mycompany.proyectoidiomas.model.entities.Profesores;
import com.mycompany.proyectoidiomas.utils.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;



public class ClasesDAO {
    
    public ArrayList<Clases> getListadoDeClases(int idProfesor){
        
        ArrayList<Clases> listaClases = new ArrayList<>();       
        
        try{
            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
                        
            Statement stm;
            ResultSet rs;
            String sql;
            
            sql = "SELECT id_clase, fecha, horario, clase_estado_id, alum_nombre, estados_clases.*\n"+
                  " FROM clases, alumnos, estados_clases\n" +
                  " WHERE clase_alumno_id = id_alum\n"+
                  " AND clase_estado_id = id_estado\n" +
                  " AND clase_profe_id = " + idProfesor +
                  " ORDER BY fecha";
            
            stm = con.createStatement();
            rs = stm.executeQuery( sql );
            
            while( rs.next() ){
                Clases clases = new Clases();
                clases.setId(rs.getInt("id_clase"));
                clases.setFecha(rs.getDate("fecha").toLocalDate());
                
                clases.setHorario(rs.getString("horario"));
                
                //System.out.print(rs.getString("alum_nombre"));
                Alumnos alumno = new Alumnos();
                alumno.setNombre(rs.getString("alum_nombre"));
                
                clases.setAlumno(alumno);
                
                EstadosClases estado = new EstadosClases(
                       rs.getInt("clase_estado_id"),
                       rs.getString("estado_nombre")
                 );
                clases.setEstado(estado);
                
                listaClases.add(clases);            
         
                }
         
            stm.close();
            rs.close();
            con.close();
            } catch (SQLException ex) {
            System.out.println(ex)    ;
            System.out.println("Error al obtener el listado alumnos");
            }
        
            return listaClases;
    
    }
    
    public ArrayList<Clases> getClasesDeAlumno(int idAlum){
        
        ArrayList<Clases> listaClases = new ArrayList<>();       
        
        try{
            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
                        
            Statement stm;
            ResultSet rs;
            String sql;
            
            sql = "SELECT id_clase, profesores.prof_nombre, fecha, horario, clase_estado_id, estado_nombre, idiomas.idioma_nombre \n" +
                "FROM clases, profesores, alumnos, estados_clases, idiomas \n" +
                "WHERE clase_alumno_id="+ idAlum +" \n" +
                "AND clase_profe_id = profesores.id_prof \n" +
                "AND alumnos.id_alum = clases.clase_alumno_id \n" +
                "AND clase_estado_id = id_estado \n" +
                "AND prof_idioma_id = idiomas.id_idioma "+
                " ORDER BY fecha";
            
            stm = con.createStatement();
            rs = stm.executeQuery( sql );
            
            while( rs.next() ){
                Clases clases = new Clases();
                clases.setId(rs.getInt("id_clase"));
                
                Profesores profesor  = new Profesores();
                profesor.setNombre(rs.getString("prof_nombre"));
                clases.setProfesor(profesor);
                
                clases.setFecha(rs.getDate("fecha").toLocalDate());
                
                clases.setHorario(rs.getString("horario"));
                                
                EstadosClases estado = new EstadosClases(
                       rs.getInt("clase_estado_id"),
                       rs.getString("estado_nombre")
                 );
                clases.setEstado(estado);
                
                Idiomas idioma = new Idiomas() ; 
                idioma.setNombre(rs.getString("idioma_nombre"));
                clases.setIdioma(idioma);
                
                listaClases.add(clases);            
         
                }
         
            stm.close();
            rs.close();
            con.close();
            } catch (SQLException ex) {
            System.out.println(ex)    ;
            System.out.println("Error al obtener las clases del alumnos");
            }
        
            return listaClases;
    
    }
    
    public void cancelarClase(int idClase) {
        try{
            ConnectionManager connectionManager = new ConnectionManager();
            
            Connection con = connectionManager.getConnection();
                        
            PreparedStatement stm;
            String sql;
           // sql = "UPDATE clases SET clase_estado_id=1 WHERE id_clase = " + idClase;
            sql = "UPDATE clases c "+
                  "INNER JOIN disponibilidad d "+
                  "ON c.clase_dispo_id = d.id_disponibilidad "+
                  "SET c.clase_estado_id = 1, d.estado = 1 "+
                  "WHERE c.id_clase = " + idClase;
            stm = con.prepareStatement(sql);
                 
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
         } catch (SQLException ex) {
            System.out.println("Error al cancelar clase");
        }
    }
    
    public void reservarClase(Clases reserva) {
        try{
            ConnectionManager connectionManager = new ConnectionManager();
            
            Connection con = connectionManager.getConnection();
                        
            PreparedStatement stm;
            String sql;
            sql = "INSERT INTO clases(clase_alumno_id, clase_profe_id, fecha, horario, clase_estado_id, clase_dispo_id)"
                    + " VALUES (?,?,?,?,?,?)";
            
            stm = con.prepareStatement(sql);
            stm.setInt(1, reserva.getAlumno().getId());
            stm.setInt(2, reserva.getProfesor().getId());
            stm.setDate(3,java.sql.Date.valueOf(reserva.getFecha()) );
            stm.setString(4, reserva.getHorario());
            stm.setInt(5, reserva.getEstado().getId());
            System.out.print(reserva.getDispo().getId());
            stm.setInt(6, reserva.getDispo().getId());
            
            stm.executeUpdate();
            
            
            stm.close();
            con.close();
         } catch (SQLException ex) {
            System.out.println("Error al reservar clase");
            System.out.println(ex);
        }
    }
    
    
    
    
    
    
    
    
}
