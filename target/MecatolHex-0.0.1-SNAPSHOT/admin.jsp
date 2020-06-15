<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href='<c:url value="/styles/styles.css?version=1" />'/>
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>Mecatol <span class="red">Hex</span></h1>
		<h3 class="subtitle">Catalogo de Juegos</h3>
		<h2>Admin</h2>
	</header>
	<main>
		<c:set var="user" value="${sessionScope.user}" />
		<c:set var="isAdmin" value="${sessionScope.isAdmin}" />
		<c:choose>
			<c:when test="${not empty user && isAdmin}">
				<div class="hex-row">
					<p class="hex">
						<a href="admin-manage-copies.jsp">Gestionar Copias</a>
					</p>
				</div>
				<div class="hex-row">
					<p class="hex">
						<a href="admin-edit-game.jsp">Editar Juego</a>
					</p>
					<p class="hex star"></p>
					<p class="hex">
						<a href="home.jsp">Inicio</a>
					</p>
				</div>
			</c:when>
			<c:when test="${not empty user && not isAdmin}">
				<div class="hex-row">
					<p class="hex"><a href="home.jsp">Inicio</a></p>
				</div>
			</c:when>
			<c:otherwise>
				<div class="hex-row">
					<p class="hex">
						<a href="index.jsp">Ingresar</a>
					</p>
				</div>
			</c:otherwise>
		</c:choose>
	</main>
</body>
</html>