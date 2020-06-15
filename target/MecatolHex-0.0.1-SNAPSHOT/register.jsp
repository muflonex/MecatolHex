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
			<h2 class="red">Registro</h2>
		</div>
	</header>
	<main>
		<c:set var="userError" value="${requestScope.userError}" />
		<c:set var="emailError" value="${requestScope.emailError}" />
		<c:set var="passwordsDifferent" value="${requestScope.passwordsDifferent}" />
		<c:set var="message" value="${requestScope.mensaje}" />
		<form action="UserRegister" method="POST">
			<div class="form-section">
				<div class="form-control">
					<label for="userName">Usuario</label>
					<input type="text" name="userName" required />
					<c:if test="${not empty userError}">
						<p class="hint">${userError}</p>
					</c:if>
				</div>
				<div class="form-control">
					<label for="email">E-mail</label>
					<input 
						type="text" 
						name="email" 
						required 
						title="algo@servidor.algo"
						pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"
					/>
				</div>
				<div class="form-control">
					<label for="password">Contraseña</label>
					<input 
						type="password" 
						name="password" 
						required
						pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}*$"
						title="Al menos 8 letras de varios tamaños, 1 número, sin espacios"
					/>
				</div>
				<div class="form-control">
					<label for="rePassword">Repetir la contraseña</label>
					<input type="password" name="rePassword" required/></p>
					<c:if test="${not empty passwordsDifferent}">
						<p class="hint">${passwordsDifferent}</p>
					</c:if>
				</div>
		
				<div class="form-control">
					<input class="button centered" type="submit" value="Registrar" />
					<a class="button centered" href="index.jsp">Volver</a>
				</div>
		
				<c:if test="${not empty message}">
					<p class="message">${message}</p>
				</c:if>
			</div>
		</form>
	</main>
</body>
</html>