<%-- 
    Document   : insertar
    Created on : 5/09/2017, 05:24:10 AM
    Author     : DELL
--%>
<%@page import="dao.Jugador"%>
<%@page import="opr.OperacionesJugador"%>
<%
        String val = request.getParameter("id_jugador");
        long id = Long.parseLong(val);
        
        OperacionesJugador oper = new OperacionesJugador();
        Jugador j = oper.consultar(id);
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page <%= id%></title>
        <link rel="stylesheet" href="./assets/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="header clearfix">
                <nav>
                    <ul class="nav nav-pills pull-right">
                        <li role="presentation"><a href="./">Home</a></li>
                        <li role="presentation"><a href="#">About</a></li>
                        <li role="presentation"><a href="#">Contact</a></li>
                    </ul>
                </nav>
                <h3 class="text-muted">CRUD JPA</h3>
            </div>
            <% if(j != null) {%>
                <form class="form-horizontal" method="post" action="./jugador/edit">
                    <div class="form-group">
                        <label for="nombres" class="col-sm-2 control-label">Nombres</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nombres" name="nombres" placeholder="Nombres" value="<%= j.getNombres()%>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="apellidos" class="col-sm-2 control-label">Apellidos</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="apellidos" name="apellidos" placeholder="Apellidos" value="<%= j.getApellidos()%>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fecha_nacimiento" class="col-sm-2 control-label">Fecha de nacimiento</label>
                        <div class="col-sm-10">
                            <input type="date" class="form-control" id="fecha_nacimiento" name="fecha_nacimiento" placeholder="Fecha de nacimiento" value="<%= j.getFechaNacimiento("yyyy-MM-dd")%>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cedula" class="col-sm-2 control-label">Cedula</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cedula" name="cedula" placeholder="Cedula" value="<%= j.getCedula()%>">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="hidden" name="id_jugador" value="<%= j.getIdJugador()%>"/>
                            <button type="submit" class="btn btn-primary">Crear</button>
                        </div>
                    </div>
                </form>
            <%} else {%>
                <div class="alert alert-info">No existe el usuario</div>
            <%}%>
        </div>
    </body>
</html>
