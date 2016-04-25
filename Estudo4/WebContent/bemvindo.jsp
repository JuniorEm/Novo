<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="br.com.estudo.jdbc.dao.*, br.com.estudo.jdbc.model.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ContatoDao contatoDao = new ContatoDao();
	%>
	<table border = "1px">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
			</tr>
		</thead>
		<%
			for (Contato contato : contatoDao.getLista()) {
		%>
		<tr>
		<tbody>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
			<%
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
			%>
			<td><%=simple.format(contato.getDataNascimento().getTime())%></td>
		</tbody>
		</tr>
		<%
			}
		%>
	</table>


</body>
</html>