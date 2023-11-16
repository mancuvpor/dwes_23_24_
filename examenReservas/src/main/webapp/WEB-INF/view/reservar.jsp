<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Resultado de reserva</title>
</head>
<body>
<h1>RESERVA CONFIRMADA</h1>
<jsp:useBean id="reservaBean" scope="session" class="Model.ReservaBean"/>
<h2>FECHA DE INICIO: <%= reservaBean.getFecha_inicio() %>
</h2>
<h2>FECHA DE FIN: <%= reservaBean.getFecha_fin() %>
</h2>
<h2>NUMERO DE PERSONAS: <%= reservaBean.getN_personas() %>
</h2>
<h2>SERVICIOS:
</h2>
<ul id="servicios">
    <%
        List<String> serviciosSeleccionados = reservaBean.getServicios();
        for (String servicio : serviciosSeleccionados) {
    %>
    <li><%= servicio %>
    </li>
    <%
        }
    %>

</ul>
</body>
</html>

<!-- Para hacer lo que tengo pensado, tengo que crear una clase que se llame Asignatura y que se ubique en la carpeta modelo
le crearia, sus atributos y en mi servlet de matricular, crear objetos de la clase Asignatura y asi poder mostrarlos a mi manera
a traves del .jsp -->