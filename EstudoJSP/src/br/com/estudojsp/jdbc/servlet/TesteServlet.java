package br.com.estudojsp.jdbc.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import br.com.estudojsp.jdbc.dao.ListaContato;
import br.com.estudojsp.jdbc.modelo.Contato;

@WebServlet("/testeServlet")
public class TesteServlet extends HttpServlet {
	
	public void init() throws ServletException {
		super.init();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String data = request.getParameter("data");

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date novaData = simpleDate.parse(data);
			Calendar dataAtual = Calendar.getInstance();
			dataAtual.setTime(novaData);
			contato.setDataNascimento(dataAtual);
		} catch (ParseException e) {
			throw new RuntimeException("Erro ao parsear data!", e);
		}

		ListaContato listaDeContatos = ListaContato.getInstance();
		
		if (!listaDeContatos.getLista().contains(contato))
			listaDeContatos.adiciona(contato);
		
		HttpSession session = request.getSession();

		session.setAttribute("lista", listaDeContatos.getLista());

		RequestDispatcher dispatcher = request.getRequestDispatcher("bemvindo.jsp");
		
		dispatcher.forward(request, response);

	}
	

}
