<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link type="text/css" rel="stylesheet" href='<c:url value="/styles/styles.css?version=1" />'/>
	<title>MecatolHex - Gestionar Copias</title>
</head>
<body class="preload">
	<header>
		<div class="brand" onload="this.classList.remove('preload')">
			<h1>Mecatol <span class="red">Hex</span></h1>
			<h3 class="subtitle">Catalogo de Juegos</h3>
		</div>
		<nav>
			<p class="hex">
				<a href="InnerControl">Inicio</a>
			</p>
			<p class="hex">
				<a href="InnerControl?action=toAdmin">Admin</a>
			</p>
			<p class="hex">Gestionar Copias</p>
		</nav>

	</header>
</body>
<script async type="module" src="./scripts/main.js"></script>
</html>