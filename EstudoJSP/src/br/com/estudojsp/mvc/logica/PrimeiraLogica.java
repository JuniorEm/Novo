package br.com.estudojsp.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PrimeiraLogica implements Logica {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("Executando primeira l�gica...");
		
		System.out.println("Retornando p�gina da primeira l�gica!");
		
		return "primeira-logica.jsp";
	}

}
