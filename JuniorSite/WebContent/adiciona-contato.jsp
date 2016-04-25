<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
<title>Adicionar Contatos</title>
</head>
<body>
	<div class="container">
		<c:import url="cabecalho.jsp" />
		<header class="page-header title-class">
		<h2>Contato</h2>
		</header>
		<div class="row">
			<div role="main" class="col-md-8">
				<form action="mvc?action=AdicionaContatoAction" method="post" accept-charset="UTF-8">
					<div class="form-group">
						<label for="inputImage">Imagem</label> <input type="file"
							accept="image" name="imagem" id="inputImage" />
					</div>
					<div class="form-group">
						<label for="inputName">Nome</label> <input type="text"
							class="form-control" name="nome" id="inputName" />
					</div>
					<div class="form-group">
						<label for="inputEmail">E-mail</label> <input type="email"
							class="form-control" name="email" id="inputEmail" />
					</div>
					<div class="form-group">
						<label for="inputTelefone">Telefone</label> <input type="text"
							class="form-control" name="telefone" id="inputTelefone" />
					</div>
					<div class="form-group">
						<label for="inputData">Data de Nascimento</label> <input
							type="text" class="form-control" name="data" id="inputData" required />
					</div>
					<div class="form-group">
						<label for="inputApresentacao">Texto de Apresenta��o</label>
						<textarea id="inputApresentacao" class="form-control" name="texto" rows="10"></textarea>
					</div>
					<script>
                        jQuery(function() {
                            $('#inputTelefone').mask('(99) 9999-9999');
                            $('#inputData').mask('99/99/9999');

                            $('#inputData').datepicker({dateFormat: 'dd/mm/yy'});
                        });
                    </script>
					<input type="submit" class="btn btn-default" value="Adicionar" />
				</form>
			</div>

			<aside role="complementary" class="col-md-4">
			<div id="widget-about" class="panel panel-default">
				<div class="panel-body">
					<h4>Informa��es</h4>
					<p>Por aqui voc�s poder�o ver links de aprendizado realizados
						diretamente por mim. Abordarei assuntos como Design Patterns,
						tecnologias novas no mercado. Pretendo crescer cada vez mais.</p>
				</div>
			</div>
			<div id="widget-links" class="panel panel-default">
				<div class="panel-body">
					<h4>Links</h4>
					<ul class="list-unstyled">
						<li><a href="#">Github</a></li>
						<li><a href="#">Twitter</a></li>
						<li><a href="#">Facebook</a></li>
					</ul>
				</div>
			</div>
			</aside>
		</div>

		<footer> <c:import url="rodape.jsp" /> </footer>

	</div>
</body>
</html>