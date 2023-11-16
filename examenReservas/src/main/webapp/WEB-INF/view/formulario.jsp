<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Datos de la reserva</title>
</head>
<body>

<form method="post">
    <h1>DATOS DE LA RESERVA</h1>
    <p><%if(session.getAttribute("error") != null) { %>
    <%= session.getAttribute("error") %>
        <% }%></p>
    <label>
        Fecha de Inicio<br>
        <input id="fecha_inicio" type="date" name="fecha_inicio">
    </label>
    <br><br>
    <label>
        Fecha de Fin<br>
        <input id="fecha_fin" type="date" name="fecha_fin">
    </label>
    <br><br>
    <label for="n_personas">
        Numero de personas<br>
        <input id="n_personas" type="number" name="n_personas">
    </label>
    <br>
    <h3>SERVICIOS</h3>
    <!--Esto es un checkbox-->
        <input type="checkbox" name="servicios" value="WIFI">Wifi</input><br>
        <input type="checkbox" name="servicios" value="TOALLAS">Toallas</input><br>
        <input type="checkbox" name="servicios" value="DESAYUNO">Desayuno</input><br>
        <input type="checkbox" name="servicios" value="LIMPIEZA">Limpieza</input><br>
        <input type="checkbox" name="servicios" value="RUTA">Ruta guiada</input><br>
        <input type="checkbox" name="servicios" value="SAUNA">Sauna</input><br>
    <br><br>
    <input type="submit" value="RESERVAR">
</form>
</body>
</html>
