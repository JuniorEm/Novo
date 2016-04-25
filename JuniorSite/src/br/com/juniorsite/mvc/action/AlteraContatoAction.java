package br.com.juniorsite.mvc.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.juniorsite.jdbc.dao.ContatoDao;
import br.com.juniorsite.jdbc.model.Contato;

public class AlteraContatoAction implements Action {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		String imagem = request.getParameter("imagem");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String data = request.getParameter("data");
		String texto = request.getParameter("texto");
		
		Contato contato = new Contato();
		contato.setId(id);
		contato.setImagem(imagem);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setTelefone(telefone);
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		contato.setDataNascimento(calendar);
		contato.setTexto(texto);
		
		ContatoDao dao = new ContatoDao();
		dao.altera(contato);
		
		return "contato-alterado.jsp";
	}

}
