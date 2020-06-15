<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link type="text/css" rel="stylesheet" href='<c:url value="/styles/styles.css?version=1" />'/>
	<title>MecatolHex - Cambio contraseÃ±a</title>
</head>
<body class="preload">
	<header>
		<div class="brand" onload="this.classList.remove('preload')">
			<h1>Mecatol <span class="red">Hex</span></h1>
			<h3 class="subtitle">Catalogo de Juegos</h3>
			<h2 class="red">Cambio contraseÃ±a</h2>
		</div>
	</header>
	<main>
		<c:set var="user" value="${sessionScope.user}" />
		<c:set var="message" value="${requestScope.message}" />
		<c:if test="${not empty user}">
			<form action="ProfilePasswordChange" method="POST">
				<div class="form-section">
					<div class="form-control">
						<label for="password">ContraseÃ±a actual</label> 
						<input type="text" name="password" />
					</div>
					<div class="form-control">
						<label for="newPassword">Nueva contraseÃ±a</label>
					 	<input type="text" name="newPassword" />
					</div>
					<div class="form-control">
						<label for="rePassword">Repetir nueva contraseÃ±a</label> 
						<input type="text" name="rePassword" />
					</div>
					<div class="form-control">
						<input class="button centered" type="submit" value="Cambiar" />
						<a class="button centered" href="profile-edit.jsp">Volver</a>
					</div>
					<c:if test="${not empty message}">
						<div class="form-control">
							<p class="message">${message}</p>		
						</div>
					</c:if>
				</div>
			</form>
		</c:if>
	</main>
</body>
<script async type="module" src="./scripts/main.js"></script>
</html>