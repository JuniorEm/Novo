package br.com.juniorsite.jdbc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.juniorsite.mvc.action.Action;
@WebServlet("/mvc")
public class ServletController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("action");
		
		try {
			Class classe = Class.forName("br.com.juniorsite.mvc.action." + parametro); //AdicionaContatoAction
			Action action = (Action) classe.newInstance(); //Cria uma nova instância da classe
			String pagina = action.executa(request, response);
			
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro inesperado", e);
		}
	}
}
