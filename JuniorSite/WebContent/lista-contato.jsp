<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contatos</title>
</head>
<body>
	<div class="container">
		<c:import url="cabecalho.jsp" />

		<header class="page-header title-class">
		<h2>Visualizar dados de contatos</h2>
		</header>

		<div class="row">
		<c:choose>
			<c:when test="${empty lista}">
				<span class="alerta">Não há nada para mostrar aqui!</span>
			</c:when>
			<c:otherwise>
			<table class="table position">
				<tr>
					<th>#</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Telefone</th>
					<th>Data de Nascimento</th>
					<th class="th-align">Opções</th>
					<th>Texto</th>
				</tr>
				<c:forEach var="contato" items="${lista}">
					<tr>
						<td>${contato.id}</td>
						<td>${contato.nome}</td>
						<td>${contato.email}</td>
						<td>${contato.telefone}</td>
						<td><fmt:formatDate value="${contato.dataNascimento.time}"
								pattern="dd/MM/yyyy"/></td>
						<td class="td-align"><a
							href="mvc?action=VisualizaContatoAction&id=${contato.id}&nome=${contato.nome}&email=${contato.email}&telefone=${contato.telefone}&data=${contato.dataNascimento.time}&texto=${contato.texto}"><span
								class="label label-success">Visualizar</span></a> 
							<a href="mvc?action=PegaContatoAction&id=${contato.id}&nome=${contato.nome}&email=${contato.email}&telefone=${contato.telefone}&data=${contato.dataNascimento.time}&texto=${contato.texto}">
							<span class="label label-warning">Editar</span></a>
							<!--  <a href="mvc?action=PegaContatoAction&id=${contato.id}"><span class="label label-warning">Editar</span></a> -->
								<a
							href="mvc?action=ExcluiContatoAction&id=${contato.id}"><span
								class="label label-danger">Excluir</span></a></td>
								<td></td>
								
					</tr>
				</c:forEach>
			</table>
			</c:otherwise>
		</c:choose>
		</div>

		<hr />
		<footer> <c:import url="rodape.jsp" /> </footer>
	</div>
</body>
</html>