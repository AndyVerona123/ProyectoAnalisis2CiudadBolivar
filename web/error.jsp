<%-- 
    Document   : error
    Created on : 05-nov-2018, 13:40:15
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
        <style type="text/css">
            .error{
                font-family: Arial,Helvetica,sans-serif;
                font-size: 17px;
                border: 1px solid;
                margin: 10px 0px;
                padding: 15px 10px 15px 50px;
                background-repeat:  no-repeat;
                background-position: 10px center;          
            }
            .error{
                color: #D8000C;
                background-color: #FFBABA;
            }
        </style>
    </head>
    <body>
    <center>
        <img src="imagenes/error.png" width="20%" height="20%" /><p></p>
        <div class="error" style="width: 50%">
            <%= mensaje != null ? mensaje : ""%>
        </div>
        <p></p>
        <br/><hr/>
        <a href="index.html">
            <img src="imagenes/home.png" width="5%" height="5%" />
        </a>
    </center>
</body>
</html>
