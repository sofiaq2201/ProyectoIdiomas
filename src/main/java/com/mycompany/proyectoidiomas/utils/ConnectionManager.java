package com.mycompany.proyectoidiomas.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    //metodo
    public Connection getConnection(){
        
        String user     = "root";
        String password = "";
        String bd       = "idiomas_db";
        String host     = "localhost";
        String port     = "3306";
        String timeZone = "America/Argentina/Buenos_Aires";
        
        String url;
        
        Connection con = null;
        
        //jdbc:mysql://localhost:3306/idiomas_db?user=root&password=""&serverTimezone=UTC
        
        url = "jdbc:mysql://" + host + ":" + port + "/" + bd + "?user=" + user + "&password=" + password + "&serverTimezone=" + timeZone;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            System.out.println("Driver cargado correctamente!");
            
            con = DriverManager.getConnection( url );
            
            System.out.println("Conectado satisfactoriamente");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el Driver de MySQL");
            
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la BD");
            System.out.println( ex.getMessage()  );
        }
        
        return con;
        
    }
    
}
