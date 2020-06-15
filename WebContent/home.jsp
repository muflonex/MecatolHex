<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link type="text/css" rel="stylesheet" href='<c:url value="/styles/styles.css?version=1" />'/>
	<title>MecatolHex - Inicio</title>
</head>
<body class="preload">
	<header>
		<div class="brand" onload="this.classList.remove('preload')">
			<h1>Mecatol <span class="red">Hex</span></h1>
			<h3 class="subtitle">Catalogo de Juegos</h3>
			<h2 class="red">Inicio</h2>
		</div>
	</header>
	<main>
		<c:set var="user" value="${sessionScope.user}" />
		<c:set var="isAdmin" value="${sessionScope.isAdmin}"/>
		<c:if test="${not empty user}">
			<div class="menu">
				<div class="hex__item profile">
					<a href="profile.jsp" class="hex__content">
						Perfil
					</a>
				</div>
				<div class="hex__item search">
					<a href="search.jsp" class="hex__content">
						Buscador
					</a>
				</div>
				<c:if test="${not empty user}">
					<div class="hex__item star">
						<a class="hex__content"></a>
					</div>
				</c:if>
				<c:if test="${isAdmin}">
					<div class="hex__item admin">
						<a href="admin.jsp" class="hex__content">
							Admin
						</a>
					</div>	
				</c:if>
			</div>
		</c:if>
		<c:if test="${empty user}">
			<div class="menu single">
				<div class="hex__item star">
					<a href="index.jsp" class="hex__content">
						Ingresar
					</a>
				</div>
			</div>
		</c:if>
	</main>
</body>
<script async type="module" src="./scripts/main.js"></script>
</html>