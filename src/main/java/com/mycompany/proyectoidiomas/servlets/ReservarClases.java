package com.mycompany.proyectoidiomas.servlets;

import com.mycompany.proyectoidiomas.model.dao.ClasesDAO;
import com.mycompany.proyectoidiomas.model.dao.DisponibilidadDAO;
import com.mycompany.proyectoidiomas.model.entities.Alumnos;
import com.mycompany.proyectoidiomas.model.entities.Clases;
import com.mycompany.proyectoidiomas.model.entities.Disponibilidad;
import com.mycompany.proyectoidiomas.model.entities.EstadosClases;
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
@WebServlet(name = "ReservarClases", urlPatterns = {"/reservar"})
public class ReservarClases extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.getAttribute("user");
        Alumnos alumno; 
        alumno = (Alumnos) session.getAttribute("user");
        request.setAttribute("user", alumno);
        
        int idProf = Integer.parseInt(request.getParameter("id"));
        //request.setAttribute("idProfe", idProf);
        
        DisponibilidadDAO dispoDAO = new DisponibilidadDAO();
        ArrayList<Disponibilidad> listaDispo = dispoDAO.getDisponibilidad(idProf);
        request.setAttribute("fechaDispo",listaDispo);
        
      
        
        
        request.getRequestDispatcher("reservarClases.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        HttpSession session = request.getSession();
        //recibo usuario alumno
        Alumnos alumno; 
        alumno = (Alumnos) session.getAttribute("user");
        
        
        //recibo id de la fecha disponible    
        int idReserva = Integer.parseInt(request.getParameter("reservaId"));
       // String horario = request.getParameter("horario");
        
              
        DisponibilidadDAO dispoDAO = new DisponibilidadDAO();
        //recibo datos de la fecha que quiero reservar
        Disponibilidad fechaReserva = dispoDAO.unaFecha(idReserva);
            
       
       System.out.print(fechaReserva.getHorario());
        
       Clases claseReserva = new Clases(fechaReserva, alumno);
        //guardo datos de la clase a reservar
       ClasesDAO cDAO = new ClasesDAO();
        //reservo clase
        cDAO.reservarClase(claseReserva);
        
        //elimino fecha disponible
        dispoDAO.deleteFecha(idReserva);
        
       
        request.getRequestDispatcher("/clases").forward(request, response);
        
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
