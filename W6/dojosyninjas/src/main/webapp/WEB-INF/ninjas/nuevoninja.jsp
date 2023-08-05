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
<title>Nuevo Ninja</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

<div class="container mx-auto">
		<h1>Nueva Ninja</h1>
		<form:form action="/ninja/new" method="POST" modelAttribute="ninja">
			<div class="form-group">
			<form:label class="form-label" path="dojo">Seleccionar Dojo: </form:label>
				<form:select class="form-control" path="dojo">
					<c:forEach items="${dojos}" var="dojo">
						<form:option value="${dojo.id }">${dojo.name }</form:option>

					</c:forEach>

				</form:select>

			</div>
			<div class="form-group">
				<form:label class="form-label" path="firstName">Name:  </form:label>
				<form:errors class="text-danger" path="firstName" />
				<form:input type="text" class="form-control" path="firstName" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="lastName">Last Name: </form:label>
				<form:errors class="text-danger" path="lastName" />
				<form:input type="date" class="form-control" path="lastName" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="age">Last Name: </form:label>
				<form:errors class="text-danger" path="age" />
				<form:input type="number" class="form-control" path="age" />
			</div>
			<button class="btn btn-success">Create Ninja</button>
		</form:form>
	</div>F

</body>
</html>
