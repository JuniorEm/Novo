package br.com.estudo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudo.jdbc.dao.LinguagemDao;
import br.com.estudo.jdbc.model.Linguagem;

/**
 * Servlet implementation class AdicionaLinguagemServlet
 */

public class AdicionaLinguagemServlet extends HttpServlet {
       

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int reputacao = Integer.parseInt(request.getParameter("reputacao"));
		String data = request.getParameter("data");
		
		Linguagem linguagem = new Linguagem();
		linguagem.setNome(nome);
		linguagem.setReputacao(reputacao);
		Calendar calendar = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			calendar.setTime(sdf.parse(data));
		} catch (ParseException e) {
			throw new RuntimeException("Erro ao parsear data!", e);
		}
		linguagem.setData(calendar);
		
		LinguagemDao dao = new LinguagemDao();
		dao.adiciona(linguagem);
		
		PrintWriter outResponse = response.getWriter();
		outResponse.println("<html>");
		outResponse.println("<body>");
		outResponse.println("<h2>Adicionado com sucesso no Banco de Dados: </h2>");
		outResponse.println("Linguagem: " + nome);
		outResponse.println("Reputação: " + reputacao);
		outResponse.println("Data de nascimento: " + data);
		outResponse.println("</body>");
		outResponse.println("</html>");
	}

}
