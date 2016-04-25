<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.estudo.jdbc.dao.*, br.com.estudo.jdbc.model.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
</head>
<body>
	<% FrutaDao frutaDao = new FrutaDao();
	%>
		<table border="2px">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Preco</th>
				</tr>
			</thead>
	<%
	for (Fruta frutaLista : frutaDao.getLista()) { %>
		<tbody>
			<tr>
				<td><%=frutaLista.getNome() %></td>
				<td><%=frutaLista.getPreco() %></td>
			</tr>
		</tbody>
	<%	
	}
	%>
		</table>
</body>
</html>