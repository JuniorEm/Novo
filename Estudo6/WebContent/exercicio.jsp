<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exibição</title>
</head>
<body>
	<jsp:useBean id="funcionarioDao"
		class="br.com.estudo.jdbc.dao.FuncionarioDao" />

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>USUARIO</th>
				<th>SENHA</th>
			</tr>
		</thead>

		<c:forEach var="funcionario" items="${funcionarioDao.lista}" varStatus="contador">
			<tbody>
				<tr bgcolor="#${contador.count % 2 == 0 ? 'FF0000' : '87CEFA'}">
					<td>${funcionario.id}</td>
					<td>${funcionario.nome}</td>
					<td>${funcionario.usuario}</td>
					<td>${funcionario.senha}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>