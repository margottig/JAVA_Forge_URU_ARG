<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./style.css" >
</head>
<body>
<h1>Tablero</h1>
	
	
	<%
	String ancho = request.getParameter("width") != null ? request.getParameter("width"):"2";
	String altura = request.getParameter("height") != null ? request.getParameter("height"):"2";
	int width = Integer.parseInt(ancho);
	int height = Integer.parseInt(altura);
	%>
	
	
	<%!
	
	public String obtenColor(int color1, int color2){
		if(color1%2 == 0){
			return color2%2 == 0 ? "black":"red";
		}
		return color2%2 == 0 ? "red":"black"; 
	}
	%>
</body>
<div>
		<h1>Checkerboard: <%= width %> x <%= height %></h1>
		<% for(int fila = 0; fila < height; fila++){ %>
			<div class="fila">
				<% for(int columna = 0; columna < width; columna++){ %>
					<div data=<%= columna %> class="square <%= obtenColor(fila, columna) %>"></div>
				<% } %>
			</div>
		<% } %>
	</div>



</html>