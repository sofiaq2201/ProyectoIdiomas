package com.mycompany.proyectoidiomas.servlets;

import com.mycompany.proyectoidiomas.model.dao.AlumnosDAO;
import com.mycompany.proyectoidiomas.model.dao.ProfesoresDAO;
import com.mycompany.proyectoidiomas.model.entities.Alumnos;
import com.mycompany.proyectoidiomas.model.entities.Profesores;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sofi
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
      
    }

    
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
       
            HttpSession session = request.getSession();
            
            String emailUsuario   = request.getParameter("emailUser");
            String password = request.getParameter("passwordUser");
            
            
            
            AlumnosDAO alumnoDAO = new AlumnosDAO();
            Alumnos alumno;
            alumno = alumnoDAO.getUserAlumno(emailUsuario);

            if(alumno.getEmail() == null){

              ProfesoresDAO profesorDAO = new ProfesoresDAO();
              Profesores profesor;
              profesor = profesorDAO.getUserProf(emailUsuario);

        
          if ( emailUsuario.equals(profesor.getEmail()) && password.equals(profesor.getPassword())){
             session.setAttribute("user", profesor);
             session.setAttribute("rol", "profesor");
             request.getRequestDispatcher("/clases").forward(request, response);   
            }else{
              request.getRequestDispatcher("inicio.jsp").forward(request, response);
            }
          }else{
            if ( emailUsuario.equals(alumno.getEmail()) && password.equals(alumno.getPassword())){
             session.setAttribute("user", alumno);
             session.setAttribute("rol", "alumno");
             
             request.getRequestDispatcher("/clases").forward(request, response);   
            }  else{
                request.getRequestDispatcher("inicio.jsp").forward(request, response);
            }
            
          } 

    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
