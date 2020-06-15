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
	<title>MecatolHex - Ingresar</title>
</head>
<body class="preload">
	<header>
		<div class="brand" onload="this.classList.remove('preload')">
			<img class="logo" alt="MecatolHex Logo" src="<c:url value='./images/logo.svg'/>">
			<h1>Mecatol <span class="red">Hex</span></h1>
			<h3 class="subtitle">Catalogo de Juegos</h3>
			<h2 class="red">Ingresar</h2>
		</div>
	</header>
	<main>
		<c:set var="userNonExistent" value="${requestScope.userNonExistent}" />
		<c:set var="passwordIncorrect" value="${requestScope.passwordIncorrect}" />
		<c:set var="message" value="${requestScope.message}" />
		<c:if test="${not empty message}">
			<p class="message">${message}</p>
		</c:if>
		<form action="Login" method="POST">
			<label for="userName">Usuario</label>
			<input 
				type="text" 
				name="userName"
				required
				placeholder="Usuario o e-mail" />
			<c:if test="${not empty usuarioNoExiste}">
				<p class="hint">${usuarioNoExiste}</p>
			</c:if>
	
			<label for="password">Contraseña</label>
			<input 
				type="password" 
				name="password" 
				required
				placeholder="Contraseña" 
			/>
			<c:if test="${not empty passwordIncorrect}">
				<p class="hint">${passwordIncorrect}</p>
			</c:if>
	
			<input class="button centered" type="submit" value="Entrar" />
			<p class="hint"><a href="ResetPassword">¿Olvidaste la contraseña?</a></p>
			<p class="hint">¿No tienes cuenta? <a href="register.jsp">Regístrate</a></p>
		</form>
	</main>
</body>
</html>