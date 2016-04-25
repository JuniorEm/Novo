package br.com.juniorsite.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.juniorsite.jdbc.dao.ContatoDao;

public class ExcluiContatoAction implements Action {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		
		ContatoDao dao = new ContatoDao();
		dao.exclui(id);
		
		return "contato-deletado.jsp";
	}

}
