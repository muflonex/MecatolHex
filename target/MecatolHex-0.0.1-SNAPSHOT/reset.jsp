<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href='<c:url value="/styles/styles.css?version=1" />'/>
<title>MecatolHex - Cambio de contraseña</title>
</head>
<body>
	<header>
		<div class="brand">
			<img class="logo" alt="MecatolHex Logo" src="<c:url value="./images/logo.svg"/>">
			<h1>Mecatol <span class="red">Hex</span></h1>
			<h3 class="subtitle">Catalogo de Juegos</h3>
			<h2 class="red">Cambiar la contraseña</h2>
		</div>
	</header>
	<main>
		<c:set var="emailNotRegistered" value="${requestScope.emailNotRegistered}" />
		<c:set var="message" value="${requestScope.message}" />
		<form action="resetPassword" method="POST">
			<label for="email">E-mail</label>
			<input 
				type="text" 
				name="email" 
				required
				title="algo@servidor.algo"
				pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$" 
				placeholder="E-mail" 
			/>
			<c:if test="${not empty emailNotRegistered}">
				<p>${emailNotRegistered}</p>
			</c:if>
			<input class="button centered" type="submit" value="Enviar" />
			<a class="button centered" href="index.jsp">Volver</a>
	
			<c:if test="${not empty message}">
				<p class="red">${message}</p>
			</c:if>
		</form>
	</main>
	
</body>
</html>