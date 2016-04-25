<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.estudo.jdbc.model.*, br.com.estudo.jdbc.dao.*, java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sucesso</title>
</head>
<body>
	<%  Linguagem linguagem = new Linguagem();
		String nome = request.getParameter("nome");
		int reputacao = Integer.parseInt(request.getParameter("reputacao"));
		String data = request.getParameter("data");
		
		linguagem.setNome(nome);
		linguagem.setReputacao(reputacao);
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		calendar.setTime(sdf.parse(data));
		
		linguagem.setData(calendar);
		
		LinguagemDao dao = new LinguagemDao();
		dao.adiciona(linguagem); 
		
	%>
	
	<h2>Adicionado com sucesso: </h2>
	<ul>
		<li><%=nome %></li>
		<li><%=reputacao %></li>
		<li><%=data %></li>
	</ul>
	<br/>
	
	
	<a href="listadelinguagens.jsp">Clique aqui para ver a lista de linguagens!</a>
		
	 
</body>
</html>