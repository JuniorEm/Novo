package br.com.juniorsite.mvc.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.juniorsite.jdbc.model.Contato;

public class PegaContatoAction implements Action {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String data = request.getParameter("data");
		String texto = request.getParameter("texto");
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
		Date date = simpleDate.parse(data);
		
		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setTelefone(telefone);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		contato.setDataNascimento(calendar);
		contato.setTexto(texto);
				
		request.setAttribute("data", new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime()));
		request.setAttribute("contato", contato);
		
		/* Com o Banco de Dados
		ContatoDao dao = new ContatoDao();
		Contato contato = dao.buscaContato(id);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String data = dateFormat.format(contato.getDataNascimento().getTime());
		request.setAttribute("contato", contato);
		request.setAttribute("dt", data);
		request.setAttribute("id", id); */
		
		return "altera-contato.jsp";
	}

}
