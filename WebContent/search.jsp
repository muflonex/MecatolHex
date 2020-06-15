<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link type="text/css" rel="stylesheet" href='<c:url value="/styles/styles.css?version=1" />'/>
	<title>MecatolHex - Buscador</title>
</head>
<body class="preload">
	<header class="subsite">
		<div class="brand">
			<h1>Mecatol <span class="red">Hex</span></h1>
			<h3 class="subtitle">Catalogo de Juegos</h3>
		</div>
		<nav>
			<div class="hex star">
				<a href="home.jsp">Inicio</a>
			</div>
			<div class="hex active">
				<h2>Buscador</h2>
			</div>
		</nav>
	</header>
	<main>
		<c:set var="user" value="${sessionScope.user}" />
		<c:if test="${not empty user}">
			<div class="card">
				<form action="Search" method="POST">
					<div class="form-section horizontal" id="search-box">
						<div class="form-control">
							<label for="name">Título</label>
							<input type="text" name="name" value="${requestScope.name}"/>
						</div>
						<div class="form-control">
							<label for="lingDependency">Dependencia lingüistica</label>
							<select name="lingDependency">
								<option></option>
								<c:forEach var="i" begin="1" end="5">
									<c:choose>
										<c:when test="${requestScope.lingDependency == i}">
											<option value="${i}" selected>${i}</option>
										</c:when>
										<c:otherwise>
											<option value="${i}">${i}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
						<div class="form-control">
							<label for="minPlayers">Min <span class="icon profile"></span></label>
							<input type="number" name="minPlayers" value="${requestScope.minPlayers}" min="1"/>
						</div>
						<div class="form-control">
							<label for="maxPlayers">Max <span class="icon profile"></span></label>
							<input type="number" name="maxPlayers" value="${requestScope.maxPlayers}" min="1"/>
						</div>
						<div class="form-control">
							<label for="playTime">Max <span class="icon clock"></span></label>
							<input type="number" name="playTime" value="${requestScope.playTime}" min="1"/>
						</div>
						<div class="form-control">
							<label for="difficulty">Complejidad</label>
							<select name="difficulty">
								<option value=""></option>
								<c:forEach var="i" begin="1" end="5">
									<c:choose>
										<c:when test="${requestScope.difficulty == i}">
											<option value="${i}" selected>${i}</option>
										</c:when>
										<c:otherwise>
											<option value="${i}">${i}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
						
						<div class="form-control">
							<input class="button" type="submit" value="Buscar">
						</div>
					</div>
				</form>
			</div>
			<div class="hex-grid">
				<c:forEach items="${requestScope.foundGames}" var="game">
					<div class="hex">
						<div class="hex__content">
							<a class="hex__link" href="SingleGame?gameId=${game.gameId}">
								<img src="<c:url value='${game.image}'/>"/>
								<p>${game.name}</p>
							</a>
						</div>
					</div>
				</c:forEach>
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