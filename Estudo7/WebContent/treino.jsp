<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainer Page</title>
</head>
<body>
	<jsp:useBean id="dao" class="br.com.estudo.jdbc.dao.LinguagemDao" />
	<table border="1px">
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>REPUTAÇÃO</th>
				<th>DATA</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="linguagem" items="${dao.lista}" varStatus="contador">
				<tr bgcolor="#${contador.count % 2 == 0 ? 'c0000' : 'f00004' }">
					<td>${linguagem.id}</td>
					<td>${linguagem.nome}</td>
					<td>${linguagem.reputacao}</td>
					<td><fmt:formatDate value="${linguagem.data.time}"
							pattern="dd/MM/yyyy" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>