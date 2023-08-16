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
<title>WaterBnB</title>
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

		<div class="row justify-content-between">
			<div class="col-2">
				<p>Current listings</p>
			</div>
			<div class="col-2">
				<a href="/logout">Logout</a> <a href="/search"> Search</a>
			</div>

		</div>
		<div class="row col-10">
			<table class="table table-hover border">
				<thead>
					<tr>
						<th>Addres</th>
						<th>Pool Size</th>
						<th>Cost per night</th>
						<th>Details</th>
					</tr>
				</thead>
				<tbody>
					<%-- 				<c:forEach items="${eventosPronvinciaUser }" var="eventoUser"> --%>
					<!-- 					<tr> -->
					<%-- 						<td><a href=" /events/${eventoUser.id}"> <c:out --%>
					<%-- 									value="${eventoUser.nombre }"></c:out></a></td> --%>

					<%-- 						<td><fmt:formatDate value="${eventoUser.fecha }" --%>
					<%-- 								pattern="MMMM dd, yyyy" var="fechaFormateada" /> <c:out --%>
					<%-- 								value="${fechaFormateada}"></c:out></td> --%>
					<%-- 						<td><c:out value="${eventoUser.ubicacion }"></c:out></td> --%>
					<%-- 						<td><c:out value="${eventoUser.provincia }"></c:out></td> --%>
					<%-- 						<td><c:out value="${eventoUser.organizador.nombre }"></c:out></td> --%>


					<%-- 						<td><c:choose> --%>
					<%-- 								<c:when test="${eventoUser.organizador.id == usuario.id }"> --%>
					<%-- 									<a href="/events/${eventoUser.id}/edit"> Edit </a> | --%>
					<%-- 									<form:form action="/events/${eventoUser.id}/delete" --%>
					<%-- 										method="post"> --%>
					<!-- 										<input type="hidden" name="_method" value="delete" /> -->
					<!-- 										<button class="btn btn-danger">Delete</button> -->
					<%-- 									</form:form> --%>

					<%-- 								</c:when> --%>
					<%-- 								<c:otherwise> --%>
					<%-- 									<c:choose> --%>
					<%-- 										<c:when test="${ eventoUser.asistentes.contains(usuario)}"> --%>
					<%-- 											<a href="/event/${eventoUser.id}/${usuario.id}/cancelar"> --%>
					<!-- 												Cancelar </a> -->
					<%-- 										</c:when> --%>
					<%-- 										<c:otherwise> --%>
					<%-- 											<a href="/event/${eventoUser.id}/${usuario.id}/unirse"> --%>
					<!-- 												Unirse </a> -->
					<%-- 										</c:otherwise> --%>
					<%-- 									</c:choose> --%>
					<%-- 								</c:otherwise> --%>

					<%-- 							</c:choose></td> --%>

					<!-- 					</tr> -->

					<%-- 				</c:forEach> --%>

				</tbody>
			</table>

		</div>

		<div class="row">
			<p>New Listing</p>
			<div class="col-6">

				<form:errors class="text-danger" path="evento.*" />

				<form:form method="POST" action="/new/pool" modelAttribute="newpool">
					<input type="hidden" path="organizador" value="${usuario.id}" />
					<div>
						<form:label path="direccion">Address:</form:label>
						<form:input type="text" path="direccion" />
						<form:errors class="text-danger" path="direccion" />
					</div>
					<div>
						<form:label path="description">Description:</form:label>
						<form:input type="text" path="description" />
						<form:errors class="text-danger" path="description" />
					</div>
					<div>
						<form:label path="costo">Cost per night:</form:label>
						<form:input type="number" path="costo" />
						<form:errors class="text-danger" path="costo" />
					</div>
					<div>
						<form:label path="poolsize">Pool Size:</form:label>
						<form:select path="poolsize" type="text" class="form-control">
							<form:option value="small"> Small</form:option>
							<form:option value="medium"> Medium</form:option>
							<form:option value="large"> Large</form:option>

						</form:select>
						<form:errors class="text-danger" path="poolsize" />
					</div>
					<input type="submit" value="Add Listing!" />
				</form:form>
			</div>
		</div>




	</div>



</body>
</html>
