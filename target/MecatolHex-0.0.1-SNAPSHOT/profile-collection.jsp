<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href='<c:url value="/styles/styles.css?version=1" />'/>
<title>MecatolHex - Mi Colecci�n</title>
</head>
<body>
	<header class="subsite">
		<div class="brand">
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
				<h2>Mi Colecci�n</h2>
			</div>
		</nav>
	</header>
	<main>
		<form action="ProfileCollection" method="POST">
			<div class="form-section horizontal">
				<div class="form-control">
					<label for="gameTitle"></label>
					<input type="text" name="gameTitle" value=""/>
				</div>
				<div class="form-control">
					<input class="button" type="submit" value="Buscar"/>
				</div>
			</div>
		</form>
		<c:set var="foundCopies" value="${requestScope.foundCopies}"/>
		<c:forEach items="${foundCopies}" var="copy">
			<div class="hex">
				<img src="<c:url value='${copy.game.image}'/>" width="200" height="200"/>
				<p><a href="Search?id=${copy.game.gameId}">${copy.game.name}</a></p>
			</div>
		</c:forEach>
	</main>
</body>
</html>