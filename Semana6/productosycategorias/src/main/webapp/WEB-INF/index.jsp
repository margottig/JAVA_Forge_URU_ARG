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
<title>Productos y Categorias</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	
	<div class="container">
		<h1>Bienvenido a Productos y Categorias</h1>
		
		<div class="col mx-auto ">
			<a class="mx-2" href="/categories/new"> Nueva Category</a> 
			<a class="mx-2" href="/products/new"> Nuevo Producto</a>
		</div>
		
		<h2> Todos los productos</h2>
		<ul>
		<c:forEach items="${productos }" var="producto">
			<li> <a href="product/${producto.id }"> <c:out value="${producto.name}"></c:out>  </a> </li>
		</c:forEach>
		</ul>
	</div>

</body>
</html>
