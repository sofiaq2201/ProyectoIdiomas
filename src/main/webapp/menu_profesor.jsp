<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-light bg-light-blue">
		 <a class="navbar-brand" href="inicio_profesor.html">LangLine</a>
		<button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			<span class="navbar-toggler-icon"></span>
		</button> 
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="navbar-nav">
				<li class="nav-item active ">
					<a class="nav-link" href="clases">Clases<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item ">
					<a href="alumnos" class="nav-link">Alumnos</a>
				</li>
				<li class="nav-item ">
					<a href="calendario" class="nav-link">Calendario</a>
				</li>			
			</ul>
			<ul class="navbar-nav ml-md-auto">
				
				<li class="nav-item dropdown">
					 <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown"><%= profesor.getNombre() %></a>
					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="logout">Cerrar Sesión</a> 
						
					</div>
				</li>
			</ul>
		</div>
</nav>