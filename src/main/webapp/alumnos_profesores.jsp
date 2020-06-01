<%@page import="com.mycompany.proyectoidiomas.model.entities.Profesores"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.proyectoidiomas.model.entities.Alumnos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
  ArrayList<Alumnos> alumnos = (ArrayList<Alumnos>) request.getAttribute("alumnos");    
  Profesores profesor = (Profesores) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Alumnos</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <%@include file="menu_profesor.jsp" %>
            <h1>Alumnos</h1>
            <div class="row">
                <div class="col">
                    <table class="table table-striped">
                    <thead>
                         
                        <tr>
                            <th scope="col">Alumnos</th>
                            <th scope="col">Email</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Alumnos unAlumno: alumnos)  {    %>
                        <tr>
                            <th scope="row"> <%= unAlumno.getNombre() %></th>
                            <td><%= unAlumno.getEmail() %></td>
                        </tr>
                        <% } %>  
                      </tbody>
                    </table>
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/popper/popper.min.js" ></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>
