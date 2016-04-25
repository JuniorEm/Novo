package br.com.pwe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OlaMundoServlet extends HttpServlet {
	private String nome;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		nome = config.getInitParameter("Nome");
		log("Inicialização da sessão!");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		printWriter.write("<html>");
		printWriter.write("<head>");
		printWriter.write("</head>");
		printWriter.write("<body>");
		printWriter.write("<h2>Olá Mundão!</h2>");
		printWriter.write("<h3>Olá, seja bem vindo " + nome + "!</h3>");
		printWriter.write("</body>");
		printWriter.write("</html>");
	}
	
	
	public void destroy() {
		super.destroy();
		log("Destruindo a servlet!");
	}

}
