<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link type="text/css" rel="stylesheet" href='<c:url value="/styles/styles.css?version=1" />'/>
	<script async type="module" src="./scripts/main.js"></script>
	<title>MecatolHex - Admin</title>
</head>
<body class="preload">
	<header>
		<div class="brand">
			<h1>Mecatol <span class="red">Hex</span></h1>
			<h3 class="subtitle">Catalogo de Juegos</h3>
			<h2>Admin</h2>
		</div>
	</header>
	<main>
		<c:set var="user" value="${sessionScope.user}" />
		<c:set var="isAdmin" value="${sessionScope.isAdmin}" />
		<c:if test="${not empty user && isAdmin}">
			<div class="menu">
				<div class="hex__item copies-white">
					<a class="hex__content" href="admin-manage-copies.jsp">Gestionar Copias</a>
				</div>
				<div class="hex__item edit">
					<a class="hex__content" href="admin-edit-game.jsp">Editar Juego</a>
				</div>
				<div class="hex__item star">
					<a class="hex__content" href="home.jsp">Inicio</a>
				</div>
			</div>
		</c:if>
		<c:if test="${not empty user && not isAdmin}">
			<div class="menu single">
				<div class="hex__item star">
					<a class="hex__content" href="home.jsp">Inicio</a>
				</div>
			</div>
		</c:if>
		<c:if test="${empty user}">
			<div class="menu single">
				<div class="hex__item star">
				<a class="hex__content" href="index.jsp">Ingresar</a>
				</div>
			</div>
		</c:if>
	</main>
</body>
<script async type="module" src="./scripts/main.js"></script>
</html>