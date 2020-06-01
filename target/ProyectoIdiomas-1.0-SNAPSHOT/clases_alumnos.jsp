<%@page import="com.mycompany.proyectoidiomas.model.entities.Alumnos"%>
<%@page import="com.mycompany.proyectoidiomas.model.entities.Clases"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
   ArrayList<Clases> clases = (ArrayList<Clases>)request.getAttribute("clases");  
   Alumnos alumno = (Alumnos) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Clases</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container"> 
            <%@include file="menu_alumnos.jsp" %>
            <h1>Proximas clases</h1>
                <div class="row">
                    <div class="col">
                            <table class="table table-striped">
                              <thead>
                                <tr>
                                  <th scope="col">Fecha</th>
                                  <th scope="col">Profesor</th>
                                  <th scope="col">Idioma</th>
                                  <th scope="col">Horario</th>
                                  <th scope="col">Estado</th>
                                  <th scope="col">-</th>
                                </tr>
                              </thead>
                              <tbody>
                                  <%for(Clases unaClase: clases){  %>
                                <tr id="fila-<%= unaClase.getId() %>">
                                  <th scope="row"> <%=unaClase.getFecha()  %> </th>
                                  <td><%=unaClase.getProfesor().getNombre()  %></td>
                                  <td><%=unaClase.getIdioma().getNombre() %></td>
                                  <td><%=unaClase.getHorario()  %></td>
                                  <% int claseEstado = unaClase.getEstado().getId() ;  
                                  if(claseEstado == 1){%>
                                  <td class="text-danger"><strong><%= unaClase.getEstado().getEstado() %></strong></td>
                                  <td >  </td>
                                  <% }else {
                                    if(claseEstado == 2){%>
                                      <td class="text-success"><strong><%= unaClase.getEstado().getEstado() %></strong></td>
                                      <td>
                                      <button data-clase-id="<%=unaClase.getId() %>" class="btn btn-outline-danger btn-sm btn-cancelar-clase" >
                                        <i class="fa fa-ban" aria-hidden="true"></i>
                                        Cancelar
                                      </button>
                                      </td>

                                   <% } else{ %>
                                        <td class="text-info"><strong><%= unaClase.getEstado().getEstado() %></strong></td>
                                        <td></td>
                                    <% }
                                    }  %>

                                </tr>
                                <% } %>
                              </tbody> 
                            </table>
                    </div>
            </div>
            
        </div>
        <div class="modal fade " tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="modalCancelarClase">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Cancelar clase</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                <div class="modal-body">
                    <form class="justify-content-center" method="POST" action="clases">
            	       	<input type="hidden" name="idClase" id="idClase" value="">
                        <input  type="hidden" name="accion" value="cancelarClase">
                        <div class="form-group">
                        <label for="text">¿Desea cancelar clase?</label> 
			</div> 
                        <div class="form-group">
                            <button class="btn btn-outline-primary" data-dismiss="modal" aria-label="Close"> No</button>
                            <input name="submit" type="submit" id="tituloCancelar" class="btn btn-outline-primary" value="Cancelar">
                        </div>
                    </form>
	      </div>
	      	 
	    </div>
	  </div>
	</div>    
           
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js" ></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    </body>
</html>
