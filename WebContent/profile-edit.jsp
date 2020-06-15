<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link type="text/css" rel="stylesheet" href='<c:url value="/styles/styles.css?version=1" />'/>
	<title>MecatolHex - Editar Perfil</title>
</head>
<body class="preload">
	<header class="subsite">
		<div class="brand" onload="this.classList.remove('preload')">
			<h1>Mecatol <span class="red">Hex</span></h1>
			<h3 class="subtitle">Catalogo de Juegos</h3>
		</div>
		<nav>
			<div class="hex star">
				<a href="home.jsp">Inicio</a>
			</div>
			<div class="hex profile">
				<a href="profile.jsp">Perfil</a>
			</div>
			<div class="hex active">
				<h2>Editar Perfil</h2>
			</div>
		</nav>
	</header>
	<c:set var="user" value="${sessionScope.user}" />
	<c:set var="message" value="${requestScope.message}"/>
	<c:if test="${not empty user}">
	<c:if test="${not empty message }">
	<p>${message}</p>
	</c:if>
	<main>
		<h3>${user.name}</h3>
		<form action="ProfileDetailsUpdate" method="POST">
			<div class="form-section horizontal">
				<div class="form-control">
					<label for="email">E-mail</label> 
					<input type="text" name="email"	value="${user.email}" /> 
				</div>
				<div class="form-control">
					<label for="address">Dirección</label> 
					<input type="text" id="address" name="address" value="${user.address.address}" /> 
				</div>
				<input class="button" type="submit" value="Cambiar" /> 
				<a href="profile-password-change.jsp">Cambiar la contraseña</a>
			</div>
			<form-section>
				<div id="map-canvas"></div>
				<input type="hidden" id="lat" name="lat" value="${user.address.lat}" min="-90" max="90" /> 
				<input type="hidden" id="lng" name="lng" value="${user.address.lng}" min="-180" max="180" />
			</form-section>
		</form>
	</main>
	</c:if>
</body>
<script	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRwd4w5MejrjWSZQ52t0R9xyujp-vtT8o"></script>
<script src='<c:url value="/scripts/maps.js"/>'></script>
<script async type="module" src="./scripts/main.js"></script>
</html>