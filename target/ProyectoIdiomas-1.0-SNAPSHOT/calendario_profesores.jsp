<%@page import="com.mycompany.proyectoidiomas.model.entities.Profesores"%>
<%@page import="com.mycompany.proyectoidiomas.model.entities.Disponibilidad"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
  ArrayList<Disponibilidad> listaFechas = (ArrayList<Disponibilidad>)request.getAttribute("fechaDispo");  
    Profesores profesor = (Profesores) request.getAttribute("user");
%>
<html>
    <head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Calendario Disponible</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
    
        <div class="container">
            <%@include file="menu_profesor.jsp" %>
            
            <div class="row mt-2">
		<div class="col-8"><h1>Fechas disponibles</h1></div>	
		<div class="col-4 ">
			<button type="button" id="btn-nueva-fecha" class="btn btn-outline-primary float-right" >
  			<i class="fa fa-calendar-plus-o fa-lg" aria-hidden="true"></i>
			</button>
		</div>
            </div>
          
            <div class="row">
		<div class="col">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col" >Fecha</th>
                                <th scope="col">Horario</th>
                                <th scope="col" >-</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                         <% for(Disponibilidad unaFecha: listaFechas) { %>       
                         <tr id='fila-<%= unaFecha.getId() %>'  >
                            <td ><%= unaFecha.getFecha() %></td>
                            <td><%= unaFecha.getHorario() %></td>
                            <td>
                                <button data-fecha-id="<%= unaFecha.getId() %>" class="btn btn-outline-success btn-sm  btn-editar-fecha"> 
                                    <i class="fa fa-pencil-square-o fa-lg" aria-hidden="true" ></i>
                                    Editar
                                </button>
                            
                                <button data-fecha-id="<%= unaFecha.getId() %>" class="btn btn-outline-danger btn-sm  btn-eliminar-fecha"> 
                                    <i class="fa fa-trash-o fa-lg" aria-hidden="true"> </i>
                                    Eliminar
                                </button>
                            </td>
                            
                          </tr>
                        <% } %>   
                        </tbody>
                    </table>
		</div>
            </div>
        
        <!-- Modal Editar / Agregar Fecha -->
        <div class="modal fade" id="modalNuevaFecha" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="titulo-nueva-fecha">Nueva fecha disponible</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="POST" action="calendario">
                            <input type="hidden" name="accion" id="accionFecha" value="">
                            <div id="box-id-fecha"></div>
                            
                            <div class="form-group row">
                                <label for="text1" class="col-4 col-form-label">Fecha</label> 
                                <div class="col-8">
                                    <input id="fecha" name="clase_fecha" type="date" class="form-control">
                                </div>
                            </div> 
                            <div class="form-group row">
                                <label for="text2" class="col-4 col-form-label">Horario</label>
                                <div class="col-8">
                                    <input id="horario" type="time"  name="clase_horario" class="form-control">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="offset-4 col-8">
                                <input id="enviarFecha" type="submit" class="btn btn-primary">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="modal fade " tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="modalEliminarFecha">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	     	<div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Eliminar fecha</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form class="justify-content-center" method="post" action="calendario">
                <input type="hidden" name="accion" value="eliminarFecha">    
                <div id="box-id-fecha-eliminar"></div>
		<div class="form-group">
		    <label for="text">¿Desea eliminar la fecha y horario?</label> 
		</div> 
		<div class="form-group">
		<button class="btn btn-outline-primary" data-dismiss="modal" aria-label="Close"> No</button>
		<input name="submit" type="submit"  class="btn btn-outline-primary" value="Eliminar">
		</div>
                </form>
	      </div>
	      
	 
	    </div>
	  </div>
	</div>
       
        <%@include file="footer.jsp" %>
     </div>
        
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js" ></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="js/calendario_prof.js"> </script>
    
    </body>
</html>
