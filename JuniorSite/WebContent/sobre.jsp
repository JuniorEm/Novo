<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sobre</title>
</head>
<body>
<div class="container">
	<c:import url="cabecalho.jsp" />
    <header class="page-header title-class">
        <h1>Sobre</h1>
    </header>
    <div class="row">
        <div role="main" class="col-md-8">
            <p>Este site tem como objetivo ilustrar todo o meu aprendizado com bootstrap,
                estou tentando copiar os códigos que estão no manual e através disso adquirir
                alguma experiência para mim. Adoro tecnologia e acredito que um dia precisarei disso.</p>

            <p>Embora eu abomine o front-end, não é verdade por inteiro. Adoro ver códigos escritos em
            JQuery. Me sinto curioso ao ouvir falar de AngularJS e NodeJS.</p>
        </div>

        <aside role="complementary" class="col-md-4">
            <div id="widget-about" class="panel panel-default">
                <div class="panel-body">
                    <h4>Informações</h4>
                    <p>Por aqui vocês poderão ver links de aprendizado realizados diretamente por mim.
                    Abordarei assuntos como Design Patterns, tecnologias novas no mercado. Pretendo crescer
                    cada vez mais.</p>
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

    <footer>
        <c:import url="rodape.jsp"/>
    </footer>

</div>
</body>
</html>