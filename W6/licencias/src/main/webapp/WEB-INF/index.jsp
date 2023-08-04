<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formateo fechas (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Formulario form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- para errores de renderizado en rutas PUT -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TODOS USUARIOS</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

	<h1>Bienvenidos a la BD de licencia de conducir</h1>
	<a href="/persons/new"> Agrega una nueva persona</a>
	<a href="/licencias/new">Agrega una nueva licencia</a>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Numero Licencia</th>
				<th>Fecha Expiracion</th>
			</tr>

		</thead>
		<tbody>
			<c:forEach items="${todos }" var="persona">
				<tr>
					<td>${persona.firstName } ${persona.lastName }</td>
					<%-- 			<td> ${persona.getLicencia().getNumber() }</td> --%>
					<td>${persona.getLicencia().getNumberComoString() }</td>
					<%-- 			<td> ${persona.getLicencia().getFechaExpiracionFormateada() }</td> --%>
					<td><fmt:formatDate pattern="MM/dd/yyy"
							value="${persona.getLicencia().getExpirationDate()}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
