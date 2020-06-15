<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link type="text/css" rel="stylesheet" href='<c:url value="/styles/styles.css?version=1" />'/>
	<title>MecatolHex - Mis Préstamos</title>
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
				<h2>Mis Préstamos</h2>			
			</div>
		</nav>
	</header>
	<main>
		<c:if test="${not empty sessionScope.user}">
			<form method="POST">
				<c:set var="allActiveLoans" value="${requestScope.allActiveLoans}"/>
				<c:forEach items="${requestScope.foundLoans}" var="loan">
					<c:set var="active" value="${empty loan.endDate}"/>
					<c:if test="${active}">
						<c:set var="loanPresent" value="true"/>
						<div class="active loan-card horizontal">
							<div class="hex">
								<img src="<c:url value='${loan.copy.game.image}'/>" width="100" height="100"/>
							</div>
							<div class="card__details">
								<h3 class="title">${loan.copy.game.name}</h3>
								<p class="start">Inicio: <b><fmt:formatDate value="${loan.startDate}" pattern="dd/MM/yyy HH:mm" /></b></p>
								<p class="bookshelf">${loan.copy.bookshelf.bookshelfId}</p>
								<p class="shelf">${loan.copy.shelf.number}</p>
								<input 
									type="submit" 
									class="button" 
									formaction="ProfileLoans?action=giveBack&id=${loan.loanId}" 
									value="Devolver" 
							/>
							</div>
						</div>
					</c:if>
					<c:if test="${!active}">
						<c:forEach items="${allActiveLoans}" var="activeLoan">
							<c:set var="copyAvailable" value="true"/>
							<c:if test="${activeLoan.copy eq loan.copy}">
								<c:set var="copyAvailable" value="false"/>
							</c:if>
						</c:forEach>
						<div class="loan-card horizontal inactive">
							<div class="hex">
								<img src="<c:url value='${loan.copy.game.image}'/>" width="100" height="100"/>
							</div>
							<div class="card__details">
								<h3 class="title">${loan.copy.game.name}</h3>
								<p class="start">Inicio: <b><fmt:formatDate value="${loan.startDate}" pattern="dd/MM/yyy HH:mm" /></b></p>
								<p class="end">Fin: <b><fmt:formatDate value="${loan.endDate}" pattern="dd/MM/yyy HH:mm" /></b></p>
								<p class="bookshelf">${loan.copy.bookshelf.bookshelfId}</p>
								<p class="shelf">${loan.copy.shelf.number}</p>
								<c:if test="${loanPresent}">
									<input type="submit" class="button disabled" value="Prestar" />
								</c:if>
								<c:if test="${!copyAvailable and not loanPresent}">
									<input type="submit" class="button disabled" value="Prestar de nuevo" />
								</c:if>
								<c:if test="${copyAvailable and not loanPresent}">
									<input 
										type="submit" 
										class="button" 
										formaction="ProfileLoans?action=takeAgain&id=${loan.loanId}"
										value="Prestar de nuevo" 
									/>
								</c:if>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</form>
		</c:if>
		<c:if test="${ empty sessionScope.user}">
			<p class="hex"><a href="index.jsp">Ingresar</a></p>
		</c:if>
	</main>
</body>
<script async type="module" src="./scripts/main.js"></script>
</html>