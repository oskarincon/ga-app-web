<%-- 
    Document   : listadoPersona
    Created on : Jul 28, 2020, 10:58:45 PM
    Author     : digital
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Persona</title>
    </head>
    <body>
        <h1>Listado Personas</h1>
        <ul>
            <c:forEach items="${personas}" var="persona">
                <li>${persona.nombre} ${persona.apellido}</li>
            </c:forEach>
        </ul>
    </body>
</html>
