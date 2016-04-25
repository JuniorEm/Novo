<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bem vindo!</title>
</head>
<body>

	<form action="testeServlet" method="POST">
		<label for="txtNome">Nome</label> <input type="text" id="txtNome"
			required name="nome" /><br /> <label for="txtEmail">Email</label> <input
			type="text" id="txtEmail" required name="email" /><br /> <label
			for="txtData">Data de Nascimento</label> <input type="text"
			id="txtData" required name="data" /> <input type="submit"
			value="Gravar" />
	</form>
	<br />
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Data</th>
			</tr>
		</thead>
		<c:forEach var="contato" items="${lista}">
			<tbody>
				<tr>
					<td>${contato.id}</td>
					<td>${contato.nome}</td>
					<td>${contato.email}</td>
					<td><fmt:formatDate value="${contato.dataNascimento.time}"
							pattern="dd/MM/yyyy" /></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>


</body>
</html>