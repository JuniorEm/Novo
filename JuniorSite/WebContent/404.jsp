<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página não encontrada</title>
</head>
<body>
	<div class="container">
		<c:import url="cabecalho.jsp" />
		<header class="page-header title-class">
			<h2>Página não encontrada!</h2>
		</header>
		
		<span class="alerta">Não encontramos o que você está procurando!</span>
		<footer>
			<c:import url="rodape.jsp" />
		</footer>
	</div>
</body>
</html>