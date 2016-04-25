package br.com.estudojsp.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PrimeiraLogica implements Logica {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("Executando primeira lógica...");
		
		System.out.println("Retornando página da primeira lógica!");
		
		return "primeira-logica.jsp";
	}

}
