<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="br.com.estudo.jdbc.dao.*, br.com.estudo.jdbc.model.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String mensagem = "Bem vindo a meu exemplo de cadastro de funcionarios!";
		String mensagem2 = "Página desenvolvida por: Junior";
	%>
	<%=mensagem%>
	<br />
	<%=mensagem2%>
	<%
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		List<Funcionario> funcionarioLista = funcionarioDao.getLista();
	%>
	<table border="2px">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Usuário</th>
				<th>Senha</th>
			</tr>
		</thead>
		<%
			for (Funcionario novaLista : funcionarioLista) {
		%>
		<tbody>
			<tr>
				<td><%=novaLista.getNome()%></td>
				<td><%=novaLista.getUsuario()%></td>
				<td><%=novaLista.getSenha()%></td>
			</tr>
		</tbody>
		<%
			}
		%>
	</table>

</body>
</html>