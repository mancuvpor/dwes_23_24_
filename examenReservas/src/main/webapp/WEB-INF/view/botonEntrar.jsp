<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Entrada al formulario</title>
</head>
<body>
<h1>CENTRAL DE VIAJES</h1>

<p><% if (!session.isNew() && session.getAttribute("error") != null) { %>
    <%= session.getAttribute("error") %>
    <% }%></p>

<form method="post">
    <label>
        Usuario
        <br>
        <input id="Usuario" type="text" name="Usuario">
    </label>
    <br><br>
    <label>
        Password
        <br>
        <input id="Password" type="text" name="Password">
    </label>
    <br><br>
    <label>
        Confirmar Password
        <br>
        <input id="Password2" type="text" name="Password2">
    </label>
    <br><br>
    <label for="Email">
        Email
        <br>
        <input id="Email" type="text" name="Email">
    </label>
    <br><br>
    <button id="boton_entrar" name="boton_entrar" value="Entrar">REGISTRARSE</button>
</form>

</body>
</html>