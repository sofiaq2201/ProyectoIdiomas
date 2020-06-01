
<%@page import="com.mycompany.proyectoidiomas.model.entities.Alumnos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%   
 /* Alumnos alumno = (Alumnos)request.getAttribute("nameAlumno");
   String alum_nombre = alumno.getNombre();
   String alum_rol = alumno.getRol();*/
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>LangLine | Inicio </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styleinicio.css" rel="stylesheet">
    
</head>
<body>

<div class="container-fluid ">
	<nav class="navbar navbar-expand-lg navbar-light ">
            <a class="navbar-brand" href="index.html">LangLine</a>
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			<span class="navbar-toggler-icon"></span>
            </button> 
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="navbar-nav ml-md-auto">
		<li class="nav-item">
                <a href="#" class="btn btn-outline-primary ml-1" role="button" data-toggle="modal" data-target="#inicio_sesion">Iniciar Sesion</a>
		</li>
		<li class="nav-item">
                    <a href="#" class="btn btn-outline-primary ml-1" data-toggle="modal" data-target="#registroAlumno">Quiero aprender</a>
		</li>
		<li class="nav-item">
                    <a href="#" class="btn btn-outline-primary ml-1" data-toggle="modal" data-target="#registroProfesor">Quiero enseñar</a>    
                </li>
            </ul>
            </div>
	</nav>
	 
	<div class="jumbotron">
  		<h1 class="display-4">¡Bienvenido a LangLine!</h1>
  		<p class="lead">¿Buscas aprender idiomas de manera online, de manera eficiente, desde cualquier parte parte del mundo y con los mejores profesores? LangLine es el lugar indicado. </p>
  	</div>
        <div class="img-index">
          <img src="images/jumbotron.png" class="img-fluid ">
        </div>
	
</div>
<!-- Modal INICIO SESION-->
<div class="modal fade" id="inicio_sesion" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Iniciar Sesion</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form action="login" method="post">
        <input type="hidden" name="tipo" value="login">
  	<div class="form-group row">
            <label for="text" class="col-4 col-form-label">Email</label> 
            <div class="col-8">
                <input id="text" name="emailUser" type="text" class="form-control">
            </div>
  	</div>
  	<div class="form-group row">
            <label for="text1" class="col-4 col-form-label">Contraseña</label> 
            <div class="col-8">
            <input id="text1" name="passwordUser" type="text" class="form-control">
    	</div>	
  	</div> 
  		<div class="form-group row">
    		<div class="offset-4 col-8">
                    <input  type="submit" class="btn btn-primary" value="Iniciar Sesión">
    		</div>
  		</div>
	</form>
      </div>
      
    </div>
  </div>
</div>

<!-- modal REGISTRO de Alumno-->

<div class="modal fade" id="registroAlumno" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Registro del Estudiante</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
            <form method="post" action="index.html">
                <input type="hidden" name="tipo" value="alumnos">
  		<div class="form-group row">
                    <label for="text" class="col-4 col-form-label">Email</label> 
                    <div class="col-8">
      			<input id="text" name="email" type="text" class="form-control">
                    </div>
                </div>
  		<div class="form-group row">
                    <label for="text1" class="col-4 col-form-label">Nombre</label> 
                    <div class="col-8">
                        <input id="text1" name="nombre" type="text" class="form-control">
                    </div>
  		</div>
                <div class="form-group row">
                    <label for="text2" class="col-4 col-form-label">Contraseña</label> 
                    <div class="col-8">
      				<input id="text2" name="password" type="text" class="form-control">
                    </div>
  		</div>
  		<div class="form-group row">
                    <div class="offset-4 col-8">
                        <input type="submit"  class="btn btn-primary" >
                    </div>
  		</div>
	</form>
      </div>
      
    </div>
  </div>
</div>


<!-- modal REGISTRO de Profesor-->

<div class="modal fade" id="registroProfesor" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Registro del Profesor</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form method="post" action="index.html" >
            <input type="hidden" name="tipo" value="profesores">
            <div class="form-group row">
                <label for="text" class="col-4 col-form-label">Email</label> 
                <div class="col-8">
                    <input id="text" name="email" type="text" class="form-control">
                </div>
            </div>
            <div class="form-group row">
                <label for="text1" class="col-4 col-form-label">Nombre</label> 
                <div class="col-8">
                    <input id="text1" name="nombre" type="text" class="form-control">
                </div>
            </div>
            <div class="form-group row">
                <label for="text2" class="col-4 col-form-label">Contraseña</label> 
                <div class="col-8">
                    <input id="text2" name="password" type="text" class="form-control">
                </div>
            </div>
            <div class="form-group row">
                <label for="idioma" class="col-4 col-form-label">Idioma que enseño</label> 
                <div class="col-8">
                  <select id="idioma" name="idioma" class="custom-select">
                    <option value="1">Inglés</option>
                    <option value="2">Español</option>
                    <option value="3">Japones</option>
                    <option value="4">Italiano</option>
                  </select>
                </div>
            </div>
            <div class="form-group row">
                <div class="offset-4 col-8">
                    <input type="submit" class="btn btn-primary" >
                </div>
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
