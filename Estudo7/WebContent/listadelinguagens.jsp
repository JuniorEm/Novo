<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.estudo.jdbc.dao.*, br.com.estudo.jdbc.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<% LinguagemDao dao = new LinguagemDao(); %>
	<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>NOME</th>
			<th>REPUTACAO</th>
			<th>DATA</th>
		</tr>
	</thead>
	<% 
		for (Linguagem novaLista : dao.getLista()) { 
			SimpleDateFormat sdf = new SimpleDateFormat(); %>
		<tbody>
			<tr>
				<td><%= novaLista.getId() %></td>
				<td><%= novaLista.getNome() %></td>
				<td><%= novaLista.getReputacao() %></td>
				<td><%= sdf.format(novaLista.getData().getTime()) %></td>
			</tr>
		</tbody>
		
	<% 
	}
	%>

	</table>
	<br/>
	
	<a href="adiciona-linguagem.html">Voltar</a>
</body>
</html>