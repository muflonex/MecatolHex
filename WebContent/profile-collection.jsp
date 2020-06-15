<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link type="text/css" rel="stylesheet" href='<c:url value="/styles/styles.css?version=1" />'/>
	<title>MecatolHex - Mi Colección</title>
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
				<a href="profile.jsp">Mi Perfil</a>
			</div>
			<div class="hex active">
				<h2>Mi Colección</h2>
			</div>
		</nav>
	</header>
	<main>
		<form action="ProfileCollection" method="POST">
			<div class="form-section horizontal">
				<div class="form-control">
					<label for="gameTitle">Título de juego</label>
					<input type="text" name="gameTitle" value="${requestScope.gameTitle}"/>
				</div>
				<div class="form-control">
					<input class="button" type="submit" value="Buscar"/>
				</div>
			</div>
		</form>
		<div class="hex-grid">
			<c:set var="foundCopies" value="${requestScope.foundCopies}"/>
			<c:forEach items="${foundCopies}" var="copy">
				<div class="hex">
					<div class="hex__content">
						<a class="hex__link" href="SingleGame?gameId=${copy.game.gameId}">
							<img src="<c:url value='${copy.game.image}'/>"/>
							<p>${copy.game.name}</p>
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
		
	</main>
</body>
<script async type="module" src="./scripts/main.js"></script>
</html>