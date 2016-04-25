package br.com.estudo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "testeServlet", urlPatterns = {"/testaServlet", "/testeServlet"},
initParams = {
		@WebInitParam(name = "parameter1", value = "Olá Mundo"),
		@WebInitParam(name = "parameter2", value = "Tchau Mundo")
})
public class TesteServlet extends HttpServlet {
	//3 Estratégias para pegar os initParam
	/* private String parameter1;
	private String parameter2; */
//1 - Sobrecarga do método init, um deles recebe um config por parâmetro e outro não
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		/* parameter1 = config.getInitParameter("parameter1");
		parameter2 = config.getInitParameter("parameter2"); */
	}
//2 - pode ser diretamente service também
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter responseWriter = response.getWriter();
		//Estratégia de Número 2
		//ServletConfig config = getServletConfig();
		//String parameter1 = config.getInitParameter("parameter1");
		responseWriter.println("<html>");
		responseWriter.println("<body>");
		responseWriter.println("<h2>Just a new Servlet</h2>");
		//Estratégia de Número3, como eu faria:
		responseWriter.println("<h1>Primeiro parâmetro: " + getServletConfig().getInitParameter("parameter1") + " e " + 
		"Segundo Parâmetro: " + getServletConfig().getInitParameter("parameter2") + "!" + "</h2>");
		responseWriter.println("</body>");
		responseWriter.println("</html>");
		
	}
}
