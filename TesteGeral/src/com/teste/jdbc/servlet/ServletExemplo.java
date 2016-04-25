package com.teste.jdbc.servlet;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
@WebServlet(name="umaServlet", urlPatterns = {"/servlet", "/littleservlet"},
	initParams = { 
			@WebInitParam(name = "param1", value = "Java"),
			@WebInitParam(name = "param2", value = "JQuery")
	}) */

public class ServletExemplo extends HttpServlet {
	private String param1;
	private String param2;
	
	public void init(ServletConfig config) throws ServletException {
		param1 = config.getInitParameter("param1");
		param2 = config.getInitParameter("param2");
	}
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Response
		response.getWriter().println("Parâmetro de início: " + param1 + " e  " + param2);
		
		//Request
		String nome = request.getParameter("nome"); //Pegou os parâmetros que o usuário forneceu
		int idade = Integer.parseInt(request.getParameter("idade"));
		
		//Response
		response.getWriter().println("Seu nome é: " + nome + " e você tem " + idade + " anos!");
	}
	
}
