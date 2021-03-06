<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Index</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="container">
		<c:import url="cabecalho.jsp" />
		<header class="page-header title-class">
		<h1>Início</h1>
		</header>

		<div class="row">
			<div role="main" class="col-md-8">
				<p>Seja bem vindo ao meu site de entretenimento. Aqui
					abordaremos as principais tecnologias do mercado!</p>
				<p>O Google liberou nesta quarta-feira (13) a segunda prévia do
					provisoriamente chamado de Android N, seu novo sistema operacional
					de smartphone e tablets. A nova versão para desenvolvedores traz
					mais emojis, como os de acrobacia, malabarismo e selfie, e a
					possibilidade de criar atalhos na tela inicial. Há ainda uma
					plataforma gráfica que melhora o desempenho do aparelho quando
					estiver executando games.</p>
				<p>Essas novidades se somam àquelas que o Google havia incluído
					no primeiro beta do Android N, colocado à disposição dos
					programadores no começo de março. O nome final do sistema ainda não
					é esse, já que a empresa tem a tradição de associar cada versão a
					algum doce (por exemplo: Kit Kat e Marshmallow. Entre os recursos
					já presentes estão o multi-janelas (para abrir dois aplicativos na
					mesma tela) e a melhoria na notificações (dá para responder
					diretamente por lá mensagens de apps de bate-papo, como WhatsApp,
					sem precisar abrir o aplicativo). Veja as novidades abaixo:</p>
				<h3>Atalhos</h3>
				<p>Com a nova rodada de atualizações, o Google leva para os
					aparelhos móveis uma ferramenta comum em computadores de mesa e
					notebooks. Os usuários poderão criar atalhos na tela inicial para
					funções específicas de dentro dos aplicativos instalados. Android N
					terá atalhos na tela inicial que levam para dentro de aplicativos.
					(Foto: Divulgação/Google) Android N terá atalhos na tela inicial
					que levam para dentro de aplicativos. Para exemplificar, o Google
					deu alguns exemplos de como colocar a novidade em prática: enviar
					uma mensagem para um contato frequente; acessar o mapa de um
					determinado local ou; assistir ao próximo episódio de um serviço
					conectado. Tudo isso sem ter de navegar por todo aplicativo.</p>
				<h3>Novos emojis</h3>
				<p>Outra alteração é a parte gráfica dos emojis. Segundo o
					Google, as imagens animadas foram modificadas para se tornarem
					menos genéricas e terem “aparência mais humana”. Além disso, as
					variações de tons de peles valerão para todos os emojis que
					representem humanos, como as representações de policial e garçom –
					antes, valiam apenas para os emojis de carinhas. Também haverá
					novas inclusão, como ícones de selfie, malabarismo, acrobacia e
					bacon.</p>
				<h3>Games</h3>
				<p>A boa notícia para quem gosta de jogar games no celular é que
					o Android N passa também a ter integração com a plataforma Vulkan
					API. Esse conjunto de ferramentas para gráficos 3D permite aos
					desenvolvedores de jogos controlar melhor como o processamento de
					imagens ocorrerá nos smartphones e tablets. Com isso, o desempenho
					desses aparelhos melhores, e os games engasgam menos. Esse recurso
					já é usado por alguns celulares que rodam Android, como Galaxy S7 e
					S7 edge, da Samsung.</p>
				<h3>Quando chega</h3>
				<p>As novas funções do Android N só chegam às mãos dos donos de
					aparelhos quando o sistema for oficialmente liberado. Outras
					novidades ainda podem ser liberadas em breve. O novo "cérebro" dos
					smartphones Android será apresentado durante evento de
					desenvolvedores Google I/O, que acontece em maio.</p>

				<span class="fonte-noticia">Fonte: <a
					href="http://g1.globo.com/tecnologia/noticia/2016/04/android-n-tera-atalho-na-tela-inicial-para-dentro-de-apps-e-emoji-de-selfie.html"
					target="_blank">globo.com</a></span> <br /> <br /> <br />
				<table class="table" id="comentarios">
					<tr>
						<td>Luizinho</td>
						<td>Achei bem interessante a notícia!</td>
						<td>
							<button onclick="RemoveTableRow(this)" type="button">Remover</button>
						</td>
					</tr>
				</table>

				<form action="#" method="post">
					<label for="inputNome">Nome</label> <input type="text"
						class="form-control" placeholder="Seu nome aqui" id="inputNome" />
					<br /> <label for="inputComentario">Comentários</label>
					<textarea id="inputComentario" class="form-control"></textarea>
					<br /> <input type="button" value="Comentar" id="botao-comentar"
						onclick="AddTableRow()" />
				</form>

				<script>
                   (function($) {
                        AddTableRow = function() {
                            var inputNome = $('#inputNome').val();
                            var inputComentario = $('#inputComentario').val();
                            var newRow = $("<tr>");
                            var cols = "";

                            cols += '<td>' + inputNome + '</td>';
                            cols += '<td> ' + inputComentario + '</td>';
                            cols += '<td>';
                            cols += '<button onclick="RemoveTableRow(this)" type="button">Remover</button>';
                            cols += '</td>';

                            newRow.append(cols);//Entregando para o mesmo tr todas as colunas coletadas
                            $('#inputNome').val("");
                            $('#inputComentario').val("");
                            newRow.fadeIn("slow"); //Efeito fadein
                            $('#comentarios').append(newRow)//Pregando na tabela
                            return false;
                        };


                    })(jQuery);

                    (function($) {
                        RemoveTableRow = function(handler) {
                            var tr = $(handler).closest('tr'); //Elemento que pega o mais próximo do botão, no caso o nosso próprio tr
                            tr.fadeOut(400, function(){
                                tr.remove();
                            });

                            return false;
                        }
                    })(jQuery);




                </script>
			</div>

			<aside role="complementary" class="col-md-4">
			<div id="widget-about" class="panel panel-info">
				<div class="panel-body">
					<h4 id="autor-dp">Autor</h4>
					<div class="default-div">
						<img alt="jr" src="img/jr.jpg" id="autor-dp-img" />
					</div>

					<p class="label-paragraph">
						<strong>Ailton Aparecido Bezerra Junior</strong>, nasceu em 05 de
						Junho de 1996, quando criança tinha o sonho de um dia se tornar um
						piloto de Formula 1, infelizmente isto não aconteceu. Em sua
						maternidade foi um apaixonado por carrinhos, também descobriu o
						PS1, sendo o primeiro video-game que seu pai permitiu tocar. Em
						sua infância foi um amante de Cavaleiros do Zodíaco assistindo
						diversas vezes todas as sagas, colecionou bonecos do tema. Em sua
						pré-adolescência, Junior foi um entusiasta do jogo virtual Habbo,
						conhecendo rivais e participando de guerras em RPGs como uma perda
						de tempo qualquer, fez inimigos e amigos e bateu com a cara no
						muro. Em sua adolescência, tornou-se guitarrista, ficando até 8
						horas por dia como um viciado qualquer, tocou desde Raul Seixas
						até Guns N' Roses. Viciado em guitarras fritantes, entrou para a
						banda da igreja e fez pouco sucesso, até hoje pretende lançar um
						disco.
					</p>
					<p>Em sua pré-fase-adulta, decidiu se tornar universitário, não
						perdendo tempo com cursinhos e faculdades disputadas, afinal, ele
						pensa que isso é perda de tempo, escolheu o curso de Sistemas de
						Informação e matriculou-se na Universidade de Mogi das Cruzes
						(Campus Villa Lobos). Tomou pal em uma porrada de matérias que
						tinha programação, inclusive algoritmos, não queria saber de
						estudar.</p>
					<p>
						Mas foi no segundo semestre de 2015 que através de um curso na <strong><a
							href="http://www.caelum.com.br">Caelum</a></strong>, que ele se apaixonou
						pela linguagem de programação Java, sendo hoje em dia um
						entusiasta dela. Ailton pegou firme e continua estudando até aqui,
						ralando, não porque quer ganhar dinheiro encima disso, mas porque
						sabe que programação vale a pena.
					</p>
					<p>Ele agradece aos mestres: Joviane, Cássio, e Renan.</p>
				</div>
			</div>
			</aside>
		</div>

		<footer> <c:import url="rodape.jsp" /> </footer>
	</div>
</body>
</html>