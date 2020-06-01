<%-- 
    Document   : reservarClases
    Created on : 24/05/2020, 01:44:37
    Author     : Sofi
--%>
<%@page import="com.mycompany.proyectoidiomas.model.entities.Disponibilidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.proyectoidiomas.model.entities.Alumnos"%>
<%
  ArrayList<Disponibilidad> listaFechas = (ArrayList<Disponibilidad>)request.getAttribute("fechaDispo");    
  Alumnos alumno = (Alumnos) request.getAttribute("user");  
  //int idProfe = Integer.parseInt(request.getParameter("idProfe"));
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Reservar Clases</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
         <%@include file="menu_alumnos.jsp" %>    
         <h1>Reservar clases</h1>   
            <div class="row">
                <div class="col">
                    <form method="POST" action="reservar" >
                        <input type="hidden" id="id-horario" name="horario" value="">
                        <table class="table table-striped">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Fecha</th>
			      <th scope="col">Horario</th>
			      
			    </tr>
			  </thead>
			  <tbody>
                              <% for(Disponibilidad unaFecha: listaFechas){ %>
			    <tr>
			      <td><input type="radio" name="reservaId" value="<%=unaFecha.getId()%>"></td>
			      <td><%=unaFecha.getFecha()%></td>
			      <td><%=unaFecha.getHorario()%></td>
			    </tr>
			    <% } %>
			  </tbody>
			</table>
                        <div class="form-group">
                            <button id="btn-reservar" class="btn btn-outline-primary" >
                                Reservar
                            </button>
			</div>
                    </form>
                </div>

            </div>
         </div>
        
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js" ></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>  
    <script>
        
    let btnReserva = document.getElementById('btn-reservar');
    btnReserva.addEventListener('click', obtengoDato);
    
    function obtengoDato(){
         var $ele = $('input[name="reservaId"]:checked');
        
        if ($ele.length) {
            let $tds = $ele.closest('tr').find('td');
            //let fecha = $tds.eq(1).text();
            let horario = $tds.eq(2).text();
                      
            //console.log(fecha);            
            console.log(horario);
            $('#id-horario').val(horario);
        }
        else {
            alert("Select a row first");
        }
    }
    
    </script>
    </body>
</html>
