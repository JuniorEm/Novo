package br.com.estudojsp.mvc.logica;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudojsp.jdbc.dao.ContatoDao;
import br.com.estudojsp.jdbc.modelo.Contato;


public class AlteraContato implements Logica {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String data = request.getParameter("data");
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		Date date = simpleDate.parse(data);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setDataNascimento(calendar);
		
		ContatoDao dao = new ContatoDao();
		dao.altera(contato);
		
		return "lista-contato.jsp";
	}

}
