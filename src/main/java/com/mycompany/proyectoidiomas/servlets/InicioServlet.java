package com.mycompany.proyectoidiomas.servlets;

import com.mycompany.proyectoidiomas.model.dao.AlumnosDAO;
import com.mycompany.proyectoidiomas.model.dao.ProfesoresDAO;
import com.mycompany.proyectoidiomas.model.entities.Alumnos;
import com.mycompany.proyectoidiomas.model.entities.Idiomas;
import com.mycompany.proyectoidiomas.model.entities.Profesores;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "InicioServlet", urlPatterns = {"/index.html","/inicio"})
public class InicioServlet extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
         HttpSession session = request.getSession();
        
        if ( session.getAttribute("user") != null ){
            System.out.print("existe sesion");
            request.getRequestDispatcher("/clases").forward(request, response);
            
        }else{
            request.getRequestDispatcher("inicio.jsp").forward(request, response);
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tipo =  request.getParameter("tipo");
        String nombre, email, password = null;
       
        
        HttpSession session = request.getSession();
        //registro alumnos
        if(tipo.equals("alumnos"))
        {
        nombre   = request.getParameter("nombre");
        email = request.getParameter("email");
        password = request.getParameter("password");
        
        AlumnosDAO alumnoDAO = new AlumnosDAO();
        
        Alumnos alumno = new Alumnos();
        alumno.setNombre(nombre);
        alumno.setEmail(email);
        alumno.setPassword(password);
        alumnoDAO.guardarAlumno(alumno); 
        
        alumno = alumnoDAO.getUserAlumno(email);
        session.setAttribute("user", alumno);
        session.setAttribute("rol", "alumno");
        
        } else {
        
                //registro profesores
                if(tipo.equals("profesores")){

                nombre   = request.getParameter("nombre");
                email = request.getParameter("email");
                password = request.getParameter("password");
                int idioma = Integer.parseInt(request.getParameter("idioma"));    

                ProfesoresDAO profesorDAO = new ProfesoresDAO();

                Profesores profesor = new Profesores();
                profesor.setEmail(email);
                profesor.setNombre(nombre);
                profesor.setPassword(password);

                Idiomas idio = new Idiomas();
                idio.setId(idioma);
                profesor.setIdioma(idio);

                profesorDAO.guardarProfesor(profesor);
                
                profesor = profesorDAO.getUserProf(email);
                
                
                session.setAttribute("user", profesor);
                session.setAttribute("rol", "profesor");
                }
        }
       
         request.getRequestDispatcher("/clases").forward(request, response);      
        
      
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
