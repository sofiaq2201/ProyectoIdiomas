package com.mycompany.proyectoidiomas.servlets;

import com.mycompany.proyectoidiomas.model.dao.ClasesDAO;
import com.mycompany.proyectoidiomas.model.entities.Alumnos;
import com.mycompany.proyectoidiomas.model.entities.Clases;
import com.mycompany.proyectoidiomas.model.entities.Profesores;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(name = "ClasesServlet", urlPatterns = {"/clases"})
public class ClasesServlet extends HttpServlet {
       
     
     public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
       
       /* HttpSession session = request.getSession();
        session.getAttribute("user");
        request.setAttribute("usuario", session.getAttribute("user"));
            
        ClasesDAO clasesDAO = new ClasesDAO();
        ArrayList<Clases> listaClases = clasesDAO.getListadoDeClases(1);
        request.setAttribute("clases",listaClases);
        
        request.getRequestDispatcher("clases_profesores.jsp").forward(request, response);*/
       
     }
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        session.getAttribute("user");
       
        ClasesDAO clasesDAO = new ClasesDAO();
        String rol = (String) session.getAttribute("rol");
        
        if(rol.equals("profesor")){
            
            Profesores profesor;
            profesor = (Profesores) session.getAttribute("user");
            request.setAttribute("user", profesor);
                       
            ArrayList<Clases> listaClases = clasesDAO.getListadoDeClases(profesor.getId());
            request.setAttribute("clases",listaClases);
            
            request.getRequestDispatcher("clases_profesores.jsp").forward(request, response);
        
        }else{
            Alumnos alumno; 
            alumno = (Alumnos) session.getAttribute("user");
            request.setAttribute("user", alumno);
            
            ArrayList<Clases> listaClases = clasesDAO.getClasesDeAlumno(alumno.getId());
            request.setAttribute("clases", listaClases);
            request.getRequestDispatcher("clases_alumnos.jsp").forward(request, response);
        }
                
}
 
   
    //estaria llegando por acá
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        session.getAttribute("user");
        
        String rol = (String) session.getAttribute("rol");
        ClasesDAO clasesDAO = new ClasesDAO();
        
        if(rol.equals("profesor")){
            
            Profesores profesor;
            profesor = (Profesores) session.getAttribute("user");
            request.setAttribute("user", profesor);
            
            System.out.println("llegue acá post clases");
            
            ArrayList<Clases> listaClases = clasesDAO.getListadoDeClases(profesor.getId());
            request.setAttribute("clases",listaClases);
             
            
            String tipo =  request.getParameter("accion");
            //cancelar Clase
            if(tipo != null && tipo.equals("cancelarClase")){
                int id = Integer.parseInt(request.getParameter("idClase"));
                clasesDAO.cancelarClase(id);
            }
            
            
            
            //request.getRequestDispatcher("clases_profesores.jsp").forward(request, response);
            this.doGet(request, response);
        
        }else{
            Alumnos alumno; 
            alumno = (Alumnos) session.getAttribute("user");
            request.setAttribute("user", alumno);
            
            ArrayList<Clases> listaClases = clasesDAO.getClasesDeAlumno(alumno.getId());
            request.setAttribute("clases", listaClases);
            System.out.print("llegue acá get clases de alumnos");
            
            
             String tipo =  request.getParameter("accion");
            //cancelar Clase
            if(tipo != null && tipo.equals("cancelarClase")){
                int id = Integer.parseInt(request.getParameter("idClase"));
                clasesDAO.cancelarClase(id);
            }
            
           // request.getRequestDispatcher("clases_alumnos.jsp").forward(request, response);
            this.doGet(request, response);
        }
        
        
  
    }
        
   

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
