<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contato adicionado com sucesso</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<br/>
	Contato ${param.nome} adicionado com sucesso!
	<c:import url="rodape.jsp" />
</body>
</html>