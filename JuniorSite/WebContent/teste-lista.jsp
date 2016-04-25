<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exemplo</title>
</head>
<body>
	<jsp:useBean id="dao" class="br.com.juniorsite.jdbc.dao.ContatoDao" />

	<table>
		<thead>
			<tr>
				<th>Foto</th>
				<th>Nome</th>
			</tr>
		</thead>

		<c:forEach var="contato" items="${dao.lista}" varStatus="contador">
			<tr>
				<td>${contato.texto}</td>
				<td>${contato.imagem}</td>
			</tr>
		</c:forEach>

		
	</table>
</body>
</html>