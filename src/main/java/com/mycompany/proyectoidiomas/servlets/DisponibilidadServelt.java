package com.mycompany.proyectoidiomas.servlets;

import com.mycompany.proyectoidiomas.model.dao.DisponibilidadDAO;
import com.mycompany.proyectoidiomas.model.entities.Disponibilidad;
import com.mycompany.proyectoidiomas.model.entities.Profesores;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "DisponibilidadServlet", urlPatterns = {"/calendario"})
public class DisponibilidadServelt extends HttpServlet {

  
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        session.getAttribute("user");
        
        Profesores profesor;
        profesor = (Profesores) session.getAttribute("user");
        request.setAttribute("user", profesor);
        
        System.out.print("llegue acá get calendario");
        
        DisponibilidadDAO dispoDAO = new DisponibilidadDAO();
        ArrayList<Disponibilidad> listaDispo = dispoDAO.getDisponibilidad(profesor.getId());
        request.setAttribute("fechaDispo",listaDispo);
        System.out.print(profesor.getId());

       request.getRequestDispatcher("calendario_profesores.jsp").forward(request, response);
         
        
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        HttpSession session = request.getSession();
        session.getAttribute("user");
        
        Profesores profesor;
        profesor = (Profesores) session.getAttribute("user");
        
        String accion = request.getParameter("accion");
        
        if(accion!=null){
            DisponibilidadDAO dispoDAO = new DisponibilidadDAO();
            if(accion.equals("nuevaFecha")){
                
                //System.out.print("nueva fecha");
                
                Disponibilidad nuevaFecha = new Disponibilidad();

                String fecha = request.getParameter("clase_fecha") ;
                String horario = request.getParameter(("clase_horario"));

                Profesores prof = new Profesores();
                prof.setId(profesor.getId());

                nuevaFecha.setIdProf(prof);
                nuevaFecha.setFecha((LocalDate) LocalDate.parse(fecha));

                nuevaFecha.setHorario(horario);

                dispoDAO.guardarNuevaFecha(nuevaFecha);
            }else{
                
                if(accion.equals("editarFecha")){
                 System.out.print("editar");
                Disponibilidad editarFecha = new Disponibilidad();
                int idFecha = Integer.parseInt(request.getParameter("idFecha"));
                String fecha = request.getParameter("clase_fecha") ;
                String horario = request.getParameter(("clase_horario"));
                
                
                editarFecha.setFecha((LocalDate) LocalDate.parse(fecha));
                editarFecha.setHorario(horario);
                editarFecha.setId(idFecha);
                
                dispoDAO.updateFecha(editarFecha);
                }else{
                    if(accion.equals("eliminarFecha")){
                        
                     
                      System.out.print("llegue a eliminar");
                      System.out.print(request.getParameter("idFecha"));
                      int idFechaEliminar = Integer.parseInt(request.getParameter("idFecha"));
                      System.out.print(idFechaEliminar);
                      dispoDAO.deleteFecha(idFechaEliminar);
                    }
                }
            }
        }
        
        
        
       this.doGet(request, response);
            
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
