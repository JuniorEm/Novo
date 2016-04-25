<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="mvc?logica=AlteraContato&id=${id}" method="POST">
		<label for="txtNome">Nome</label> <input type="text" id="txtNome"
			name="nome" value="${contato.nome}" /><br /> <label for="txtEmail">Email</label>
		<input type="text" id="txtEmail" name="email" value="${contato.email}" /><br />
		<label for="txtData">Data de Nascimento</label> <input type="text"
			id="txtData" name="data" required
			value="<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>" /><br />
		<u:campoData id="txtData"></u:campoData>
		<input type="submit" value="Alterar" />
	</form>
</body>
</html>