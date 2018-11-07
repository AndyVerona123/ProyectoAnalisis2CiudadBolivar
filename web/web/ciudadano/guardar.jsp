<%-- 
    Document   : guardar
    Created on : 04-nov-2018, 15:16:13
    Author     : Andres
--%>
<%
    String mensaje = (String) request.getAttribute("mensaje");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcaldia de ciudad Bolivar</title>
    </head>
    <body>
    <center>
        <h1> 
            <b>Ciudadano</B>
        </h1>
    </center>
    <hr style="width: 50%">
    <div style="text-align: center">
        <form action="/ProyectoCiudadBolivar/ServletCiudadano" method="POST" name="formulario1">
            <fieldset style="margin: 0 auto; text-align: left; width: 40%">
                <legend><b>Datos para agregar un nuevo ciudadano</b></legend>
                <table border="0" style="margin: 0 auto; text-align: left; width: 70%">
                    <tr>
                        <th style="width: 30%">Nombre</th>
                        <td style="width: 70%"> <input type="text" name="nombre" value="" style="width: 98%"/></td>
                    </tr>
                    <tr>
                        <th style="width: 30%">Apellido</th>
                        <td style="width: 70%"><input type="text" name="apellido" value="" style="width: 98%"/></td>
                    </tr>
                    <tr>
                        <th style="width: 30%">Cedula</th>
                        <td style="width: 70%"><input type="number" name="cedula" style="width: 98%"/></td>
                    </tr>
                    <tr>
                        <th style="width: 30%">Correo</th>
                        <td style="width: 70%"><input type="email" name="correo" style="width: 98%"/></td>
                    </tr>
                    <tr>
                        <th style="width: 30%">Contraseña</th>
                        <td style="width: 70%"><input type="password" name="contra" style="width: 98%"/></td>
                    </tr>
                    <tr>
                        <td style="width: 30%; text-align: center" colspan="2">
                            <input type="submit" name="accion" value="Guardar"/>
                            <input type="reset" value="Restaurar" /></td>
                    </tr>
                </table>
            </fieldset
        </form>
    </div>
    <hr style="width: 50%">
    <p style="text-align: center"><span style="color: red" ><%= mensaje != null ? mensaje : ""%></span></p>
</body>
</html>
