package br.com.estudojsp.jdbc.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudojsp.jdbc.dao.ContatoDao;
import br.com.estudojsp.jdbc.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contato contato = new Contato();
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date date = simpleDate.parse(request.getParameter("data"));
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			contato.setDataNascimento(calendar);
		} catch (ParseException e) {
			throw new RuntimeException("Erro ao parsear data!", e);
		}
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/contato-adicionado.jsp");
		dispatcher.forward(request, response);
	}
	
}
