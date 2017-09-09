<%@page import="util.ManejadorPropiedades"%>
<%@page import="util.SessionUtil"%>
<!DOCTYPE html>
<%
    HttpSession httpSession = request.getSession();
    String message = SessionUtil.getFlashMessage(httpSession);%>
<html>
    <head>
        <title><%=ManejadorPropiedades.obtenerValor("titulo")%> - <%=ManejadorPropiedades.obtenerValor("version")%></title>
        <meta name="author" content="<%=ManejadorPropiedades.obtenerValor("autor")%>">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" href="./assets/css/bootstrap.min.css">
        <script src="./assets/js/jquery-3.2.1.js"></script>
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
            <% if (message != null && !message.equals("")) {%>
            <div class="alert alert-info alert-auto-hide">
                <%= message%>
            </div>
            <%}%>
            <div class="jumbotron">
                <h1>CRUD JPA</h1>
                <p class="lead">CRUD de la tabla jugador realizado con JPA</p>
                <!--<p><a class="btn btn-lg btn-success" href="#" role="button">Sign up today</a></p>-->
            </div>

            <div class="row marketing">
                <div class="col-lg-6">
                    <h4>Insertar</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>
                    <p class="text-center"><a class="btn btn-primary btn-lg" href="insertar.jsp">Insertar</a></p>

                    <h4>Buscar</h4>
                    <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>
                    <form class="form-inline" action="buscar.jsp" method="get">
                        <div class="form-group">
                            <label for="id_jugador">Id Jugador</label>
                            <input type="number" class="form-control" id="id_jugador" placeholder="ID" name="id_jugador">
                        </div>
                        <button type="submit" class="btn btn-primary">Buscar</button>
                    </form>
                </div>

                <div class="col-lg-6">
                    <h4>Editar</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>
                    <form class="form-inline" action="editar.jsp" method="get">
                        <div class="form-group">
                            <label for="id_jugador">Id Jugador</label>
                            <input type="number" class="form-control" id="id_jugador" placeholder="ID" name="id_jugador">
                        </div>
                        <button type="submit" class="btn btn-primary">Editar</button>
                    </form>
                    <h4>Eliminar</h4>
                    <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>
                    <form class="form-inline" action="./jugador/delete" method="post">
                        <div class="form-group">
                            <label for="id_jugador">Id Jugador</label>
                            <input type="number" class="form-control" id="id_jugador" placeholder="ID" name="id_jugador">
                        </div>
                        <button type="submit" class="btn btn-primary">Eliminar</button>
                    </form>
                </div>
            </div>

            <footer class="footer navbar-fixed-bottom">
                <div class="container">
                    <span class="navbar-text">
                        © 2016 Company, Inc.
                    </span>
                </div>
            </footer>

        </div>
        <script type="text/javascript">
            $(".alert-auto-hide").fadeTo(2000, 500).slideUp(500, function() {
                $("alert-auto-hide").slideUp(500);
            });
        </script>
    </body>
</html>
