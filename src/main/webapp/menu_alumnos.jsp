<%-- 
    Document   : menu_profesores
    Created on : 21/05/2020, 23:15:01
    Author     : Sofi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light-blue">
    <a class="navbar-brand" href="">LangLine</a>
    <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="navbar-toggler-icon"></span>
    </button> 
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	<ul class="navbar-nav">
            <li class="nav-item active">
		<a class="nav-link" href="clases">Clases<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">Idiomas</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="#">Inglés</a> 
                    <a class="dropdown-item" href="#">Español</a> 
                    <a class="dropdown-item" href="#">Japonés</a>
                    <a class="dropdown-item" href="#">Italiano</a>
                </div>
            </li>
	</ul>
        <form class="form-inline" method="POST" action="busqueda">
            <input class="form-control mr-sm-2" type="text" name="search" placeholder="Busqueda de Profesores" /> 
            <button class="btn btn-primary my-2 my-sm-0" type="submit">
                Search
            </button>
	</form>
        <ul class="navbar-nav ml-md-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown"><%=alumno.getNombre() %></a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item" href="logout">Cerrar Sesión</a> 
                </div>
            </li>
        </ul>
    </div>
</nav>
