package com.mycompany.proyectoidiomas.servlets;

import com.mycompany.proyectoidiomas.model.dao.ProfesoresDAO;
import com.mycompany.proyectoidiomas.model.entities.Alumnos;
import com.mycompany.proyectoidiomas.model.entities.Profesores;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "BusquedaServlet", urlPatterns = {"/busqueda"})
public class BusquedaServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        session.getAttribute("user");
        Alumnos alumno; 
        alumno = (Alumnos) session.getAttribute("user");
        request.setAttribute("user", alumno);
        
        String busqueda = request.getParameter("busqueda");
                
        if(busqueda!=null){
            //busca por idioma
        
        }{
           //busqueda general de profesores
           ProfesoresDAO profDAO = new ProfesoresDAO();
           ArrayList<Profesores> listaProfesores = profDAO.getProfesores();
           request.setAttribute("profesores", listaProfesores);
                      
         }
        request.getRequestDispatcher("busqueda.jsp").forward(request, response);
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
