package br.com.juniorsite.mvc.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.juniorsite.jdbc.dao.ContatoDao;
import br.com.juniorsite.jdbc.model.Contato;

public class AdicionaContatoAction implements Action {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String imagem = request.getParameter("imagem");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String data = request.getParameter("data");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse(data);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String texto = request.getParameter("texto");
		
		Contato contato = new Contato();
		contato.setImagem(imagem);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setTelefone(telefone);
		contato.setDataNascimento(calendar);
		contato.setTexto(texto);
		
		new ContatoDao().adicionaContato(contato);
		
		return "contato-adicionado.jsp";
	}

}
