<%-- 
    Document   : insertar
    Created on : 5/09/2017, 05:24:10 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            <form class="form-horizontal" method="post" action="./jugador/insert" id="insertForm">
  <div class="form-group">
    <label for="nombres" class="col-sm-2 control-label">Nombres</label>
    <div class="col-sm-10">
        <input type="text" class="form-control valid-required" id="nombres" name="nombres" placeholder="Nombres">
        <!--<span id="helpBlock2" class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>-->
    </div>
  </div>
                <div class="form-group">
    <label for="apellidos" class="col-sm-2 control-label">Apellidos</label>
    <div class="col-sm-10">
        <input type="text" class="form-control valid-required" id="apellidos" name="apellidos" placeholder="Apellidos">
    </div>
  </div>
  <div class="form-group">
    <label for="fecha_nacimiento" class="col-sm-2 control-label">Fecha de nacimiento</label>
    <div class="col-sm-10">
        <input type="date" class="form-control valid-required" id="fecha_nacimiento" name="fecha_nacimiento" placeholder="Fecha de nacimiento">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary" id="submit">Crear</button>
    </div>
  </div>
</form>
        </div>
        <script type="text/javascript">
            function requireField(){
                var value = $(this).val();
                if (value === null || value === '' || value === 0) {
                    $(this).closest('.form-group').addClass('has-error');
                } else {
                    $(this).closest('.form-group').removeClass('has-error');
                }
            }
            $('.valid-required').keyup(requireField);
            $('#submit').click(function (event) {
                $('.valid-required').each(requireField);
                if ($('#insertForm').find('.has-error').length > 0) {
                    event.preventDefault();
                    alert('El formulario contiene errores');
                }
            })
        </script>
    </body>
</html>
