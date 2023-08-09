<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Testing JSP file</h1>

<p> Name: <c:out value="${name }"></c:out>   </p>
<p> Item : <c:out value="${itemNombre }"></c:out>   </p>
<p> Precio: <c:out value="${price }"></c:out>   </p>
<p> Descripcion: <c:out value="${desc }"></c:out>   </p>


<!-- Esta forma no es correcta, tener en cuenta -->
<p> ${name }   </p>





</body>
</html>