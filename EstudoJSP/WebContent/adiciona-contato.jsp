<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<link href="css/jquery.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Página de adicionar contato</title>

</head>
<body>
	<c:import url="cabecalho.jsp"/><br/>
	
	<form action="adicionaContato">
		<label for="txtNome">Nome</label>
		<input type="text" id="txtNome" name="nome" /><br/>
		<label for="txtEmail">Email</label>
		<input type="text" id="txtEmail" name="email" /><br/>
		<label for="txtData">Data de Nascimento</label>
		<input type="text" id="txtData" name="data" required /><br/>
		<u:campoData id="txtData"></u:campoData>
		<input type="submit" value="Gravar" />
	</form>
	<c:import url="rodape.jsp"/>
</body>
</html>