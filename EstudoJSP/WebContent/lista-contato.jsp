<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Minha lista de Contatos</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	<jsp:useBean id="contato" class="br.com.estudojsp.jdbc.dao.ContatoDao" />
	<br />
	<h2>Lista de contatos do Juninho</h2>
	<br />
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>nome</th>
				<th>email</th>
				<th>data nascimento</th>
			</tr>
		</thead>
		<c:forEach var="novoContato" items="${contato.lista}"
			varStatus="contador">
			<tbody>
				<tr bgcolor="${contador.count % 2 == 0 ? '#FF7F50' : '#7B68EE' }">
					<td><c:choose>
							<c:when test="${empty novoContato.id}">
				ID não informado!
			</c:when>
							<c:otherwise>
				${novoContato.id}
			</c:otherwise>
						</c:choose></td>

					<td><c:choose>
							<c:when test="${empty novoContato.nome}">
				Nome não informado! </c:when>
							<c:otherwise>
				${novoContato.nome}
				</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${not empty novoContato.email}">
								<a href="mailto:${novoContato.email}">${novoContato.email}</a>
							</c:when>
							<c:otherwise>
					Email não informado!
				</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate value="${novoContato.dataNascimento.time}"
							pattern="dd/MM/yyyy" /></td>
					<td><a href="mvc?logica=PegaContato&id=${novoContato.id}" target="_blank">Alterar</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	
	<a href="adiciona-contato.jsp">Voltar</a>
	
	<br/>
	<a href="mvc?logica=PrimeiraLogica"><input type="button" value="Executar primeira lógica"/></a>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>