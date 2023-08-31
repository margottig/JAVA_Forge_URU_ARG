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
<title>AQUI EL TITULO DE TU PLNATILLA</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>


	<div class="container">

		<c:forEach begin="1" end="${totalpaginas }" var="index">
			<a href="/pages/${index }"> <c:out value="${index }"></c:out></a>

		</c:forEach>

		<table class="table">

			<thead>
				<th>First Name</th>
				<th>Last Name</th>
			</thead>
			<tbody>

				<c:forEach var="ninja" items="${ninjas.content }">
					<tr>
						<td><c:out value="${ninja.firstName }"></c:out></td>
						<td><c:out value="${ninja.lastName }"></c:out></td>
					</tr>


				</c:forEach>



			</tbody>
		</table>
	</div>

</body>
</html>
