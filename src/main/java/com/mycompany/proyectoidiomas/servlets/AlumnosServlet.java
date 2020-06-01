package com.mycompany.proyectoidiomas.servlets;

import com.mycompany.proyectoidiomas.model.dao.AlumnosDAO;
import com.mycompany.proyectoidiomas.model.entities.Alumnos;
import com.mycompany.proyectoidiomas.model.entities.Profesores;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "AlumnosServlet", urlPatterns = {"/alumnos"})
public class AlumnosServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        HttpSession session = request.getSession();
        session.getAttribute("user");
        
            Profesores profesor;
            profesor = (Profesores) session.getAttribute("user");
            request.setAttribute("user", profesor);
       
        ArrayList<Alumnos> listaAlumnos = alumnosDAO.getAlumnosDelProfesor(profesor.getId());
        request.setAttribute("alumnos", listaAlumnos);
        
        request.getRequestDispatcher("alumnos_profesores.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        HttpSession session = request.getSession();
        session.getAttribute("user");
        
        Profesores profesor;
        profesor = (Profesores) session.getAttribute("user");
        request.setAttribute("user", profesor);
            
        
        ArrayList<Alumnos> listaAlumnos = alumnosDAO.getAlumnosDelProfesor(1);
        request.setAttribute("alumnos", listaAlumnos);
        
       request.getRequestDispatcher("alumnos_profesores.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
