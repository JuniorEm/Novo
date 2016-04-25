package br.com.estudojsp.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudojsp.jdbc.dao.ContatoDao;
import br.com.estudojsp.jdbc.modelo.Contato;

public class PegaContato implements Logica {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		
		ContatoDao dao = new ContatoDao();
		Contato contato = dao.getContato(id);
		
		request.setAttribute("contato", contato);
		
		return "pagina-altera.jsp";
	}

}
