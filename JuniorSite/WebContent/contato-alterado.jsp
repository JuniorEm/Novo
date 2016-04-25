<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contato alterado!</title>
</head>
<body>
	<div class="container">
		<c:import url="cabecalho.jsp" />
		<header class="page-header title-class">
		<h2>Sucesso!</h2>
		</header>
		O contato ${param.nome} foi alterado com sucesso!
			<footer> <c:import url="rodape.jsp" /> </footer>
	</div>

</body>
</html>