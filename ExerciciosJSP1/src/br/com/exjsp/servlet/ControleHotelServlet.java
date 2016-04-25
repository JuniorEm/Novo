package br.com.exjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controleHotel")
public class ControleHotelServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String quantidade = request.getParameter("qtdDias");
		int novaQuantidade = Integer.parseInt(quantidade);
		double acumulador = 0;
		
		for (int i = 1; i <= novaQuantidade; i++) {
			acumulador = acumulador + (100/i);
		}

		request.setAttribute("acumulador", acumulador);

		RequestDispatcher rd = request.getRequestDispatcher("/controlehotel.jsp");
		rd.forward(request, response);
		
	}
}
