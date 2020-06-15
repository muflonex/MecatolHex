<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href='<c:url value="/styles/styles.css?version=1" />'/>
<title>Mecatol Hex - Perfil</title>
</head>
<body>
	<header>
		<div class="brand">
			<h1>Mecatol <span class="red">Hex</span></h1>
			<h3 class="subtitle">Catalogo de Juegos</h3>
			<h2 class="red">Perfil</h2>
		</div>
	</header>
	<main>
		<c:set var="user" value="${sessionScope.user}" />
		<c:if test="${not empty user}">
			<div class="menu">
				<div class="hex__item profile-edit">
					<a href="profile-edit.jsp" class="hex__content">
						Editar Perfil
					</a>
				</div>
				<div class="hex__item collection">
					<a href="ProfileCollection" class="hex__content">
						Mi Colección
					</a>
				</div>
				<div class="hex__item star">
					<a href="home.jsp" class="hex__content">
						Inicio
					</a>
				</div>
				<div class="hex__item loan">
					<a href="ProfileLoans" class="hex__content">
						Mis Préstamos
					</a>
				</div>
			</div>
		</c:if>
		<c:if test="${empty user}">
			<div class="menu single">
				<div class="hex__item star">
					<a href="index.jsp" class="hex__content">Ingresar</a>
				</div>
			</div>
		</c:if>
	</main>
</body>
</html>