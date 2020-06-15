<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href='<c:url value="/styles/styles.css?version=1" />'/>
<title>MecatolHex - Buscador</title>
</head>
<body>
	<header class="subsite">
		<div class="brand">
			<h1>Mecatol <span class="red">Hex</span></h1>
			<h3 class="subtitle">Catalogo de Juegos</h3>
		</div>

		<nav>
			<p class="hex">
				<a href="home.jsp">Inicio</a>
			</p>
			<p class="hex">Buscador</p>
		</nav>
	</header>
	<main>
		<c:set var="user" value="${sessionScope.user}" />
		<c:if test="${not empty user}">
			<p>Buscador</p>
		</c:if>
		<c:if test="${empty user}">
			<p class="hex">
				<a href="index.jsp">Ingresar</a>
			</p>
		</c:if>
	</main>
</body>
</html>