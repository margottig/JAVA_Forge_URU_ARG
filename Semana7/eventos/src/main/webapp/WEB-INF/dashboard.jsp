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
<title>APP</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

	<div class="container">

		<h1>
			Welcome,
			<c:out value="${usuario.nombre }"></c:out>
		</h1>
		<div class="text-end">
			<a href="/logout">Logout</a>
		</div>

		<hr>
		<h3>Here are some events in your state:</h3>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Location</th>
					<th>Province</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>


		<hr />

		<h3>Here are some events in other state:</h3>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Location</th>
					<th>Province</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>
 
 		<div class="col-6">
			<form:form method="POST" action="/nuevo/evento" modelAttribute="evento">
			<form:input type="hidden" path="organizador" value="${usuario.id}"/>
				<div>
					<form:label path="nombre">Event Name:</form:label>
					<form:input type="text" path="nombre" />
				</div>
				<div>
					<form:label path="fecha">Event date:</form:label>
					<form:input type="date" path="fecha" />
				</div>
				<div>
					<form:label path="ubicacion">Location:</form:label>
					<form:input type="text" path="ubicacion" />
				</div>
				<div>
					<form:label path="provincia">State:</form:label>
					<form:select path="provincia" type="text" class="form-control">
						<c:forEach items="${provincias}" var="provincia">
							<form:option value="${provincia }"></form:option>
						</c:forEach>
					</form:select>
				</div>		
				<input type="submit" value="Create Event!" />
			</form:form>
		</div>




	</div>



</body>
</html>
