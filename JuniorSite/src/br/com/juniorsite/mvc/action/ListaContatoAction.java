package br.com.juniorsite.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.juniorsite.jdbc.dao.ContatoDao;

public class ListaContatoAction implements Action {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ContatoDao contatoDao = new ContatoDao();
		request.setAttribute("lista", contatoDao.getLista());
		
		return "lista-contato.jsp";
	}

}
