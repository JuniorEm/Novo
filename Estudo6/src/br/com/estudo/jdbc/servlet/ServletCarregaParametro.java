package br.com.estudo.jdbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (name = "ServletCarregaParametro", urlPatterns = {"/carregaParametro"},
initParams = {
		@WebInitParam(name = "param1", value = "value1"),
		@WebInitParam(name = "param2", value = "value2")
})
public class ServletCarregaParametro extends HttpServlet {
	String param1;
	String param2;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		param1 = this.getInitParameter("param1");
		param2 = this.getInitParameter("param2");
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Response
		PrintWriter writer = response.getWriter();
		writer.println("Valor inicial de Parâmetro1, valor: " + param1);
		writer.println("Valor inicial de Parâmetro2, valor: " + param2);
		
		//Request
		param1 = request.getParameter("parametro1");
		param2 = request.getParameter("parametro2");
		
		//Response
		writer.println("Parâmetro passado pelo usuário, valor 1: " + param1);
		writer.println("Parâmetro passado pelo usuário, valor2: " + param2);
		

	}
}
