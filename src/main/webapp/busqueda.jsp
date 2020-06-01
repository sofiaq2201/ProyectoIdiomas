
<%@page import="com.mycompany.proyectoidiomas.model.entities.Alumnos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.proyectoidiomas.model.entities.Profesores"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Profesores> profesores = (ArrayList<Profesores>)request.getAttribute("profesores");  
    Alumnos alumno = (Alumnos) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Busqueda</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <%@include file="menu_alumnos.jsp" %>
            <h1>Busquedas</h1>
            
            <% for(Profesores unProfe : profesores){ %>
            <div class="row mt-2">
		<div class="col">
                    <div class="card" style="width: 35rem;">
			<div class="card-header ">
                            <strong> <%=unProfe.getNombre() %>  </strong>           
                        </div>
                        <div class="row m-2 ">
                            <div class="col-8 m-2">Idioma: <%=unProfe.getIdioma().getNombre() %></div>
				<div class="col m-2 justify-content-right ">
                                    <a href="reservar?id=<%=unProfe.getId()%>" class="btn btn-outline-success btn-sm">
					<i class="fa fa-calendar-plus-o" aria-hidden="true"></i>
					Reservar
                                    </a>
				</div>
                            </div>
                    </div>
		</div>
            </div>
            <% } %>
        </div>
        
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js" ></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
