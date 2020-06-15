<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href='<c:url value="/styles/styles.css?version=1" />'/>
<title>MecatolHex - Mis Préstamos</title>
</head>
<body>
	<header class="subsite">
		<div class="brand">
			<h1>Mecatol <span class="red">Hex</span></h1>
			<h3 class="subtitle">Catalogo de Juegos</h3>
		</div>
		<nav>
			<p class="hex">
				<a href="home.jsp">Inicio</a>
			</p>
			<p class="hex">
				<a href="profile.jsp">Mi Perfil</a>
			</p>
			<p class="hex">Mis Préstamos</p>
		</nav>
	</header>
	<main>
		<c:if test="${not empty sessionScope.user}">
			<c:set var="allActiveLoans" value="${requestScope.allActiveLoans}"/>
			<p>${allActiveLoans}</p>
			<c:forEach items="${requestScope.foundLoans}" var="loan">
				<c:set var="active" value="${empty loan.endDate}"/>
				<c:if test="${active}">
					<div class="active card horizontal">
						<div class="hex"><img src="<c:url value='${loan.copy.game.image}'/>" width="100" height="100"/></div>
						<h3 class="title">${loan.copy.game.name}</h3>
						<p class="start">Inicio: <fmt:formatDate value="${loan.startDate}" pattern="dd/MM/yyy HH:mm" /></p>
						<p class="bookshelf">${loan.copy.bookshelf}</p>
						<p class="shelf">${loan.copy.shelf}</p>
						<a class="button" href="ProfileLoans?action=giveBack&id=${copy.game.gameId}">Devolver</a>
					</div>
				</c:if>
				<c:if test="${!active}">
					<c:set var="copyAvailable" value="${!allActiveLoans.contains(loan.copy)}"/>
					<div class="card horizontal">
						<div class="hex">
							<img src="<c:url value='${loan.copy.game.image}'/>" width="100" height="100"/>
						</div>
						<h3 class="title">${loan.copy.game.name}</h3>
						<p class="start">Inicio: <fmt:formatDate value="${loan.startDate}" pattern="dd/MM/yyy HH:mm" /></p>
						<p class="end">Fin: <fmt:formatDate value="${loan.endDate}" pattern="dd/MM/yyy HH:mm" /></p>
						<p class="bookshelf">${loan.copy.bookshelf.bookshelfId}</p>
						<p class="shelf">${loan.copy.shelf.number}</p>
						<c:if test="${loanActive}">
							<a class="button disabled" href="ProfileLoans?action=takeAgain&id=${copy.game.gameId}">Prestar</a>
						</c:if>
						<c:if test="${copyAvailable}">
							<a class="button" href="ProfileLoans?action=takeAgain&id=${copy.game.gameId}">Prestar</a>
						</c:if>
					</div>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${ empty sessionScope.user}">
			<p class="hex"><a href="index.jsp">Ingresar</a></p>
		</c:if>
	</main>
</body>
</html>