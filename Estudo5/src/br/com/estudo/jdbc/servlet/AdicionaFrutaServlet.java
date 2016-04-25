package br.com.estudo.jdbc.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudo.jdbc.dao.FrutaDao;
import br.com.estudo.jdbc.model.Fruta;

public class AdicionaFrutaServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestParameter = request.getParameter("nome");
		double requestParameter2 = Double.parseDouble(request.getParameter("preco"));
		
		Fruta fruta = new Fruta();
		fruta.setNome(requestParameter);
		fruta.setPreco(requestParameter2);
		
		FrutaDao frutaDao = new FrutaDao();
		frutaDao.adiciona(fruta);
		PrintWriter meuEscrevedor = response.getWriter();
		meuEscrevedor.println("<html>");
		meuEscrevedor.println("<head>");
		meuEscrevedor.println("</head>");
		meuEscrevedor.println("<body>");
		meuEscrevedor.println("<h1>Adicionado no Banco de Dados a Fruta " + fruta.getNome() + " de Preço " + fruta.getPreco() + "!</h1>");
		/*
		meuEscrevedor.println("<br />");
		meuEscrevedor.println("Resultados do Banco de Dados: ");
		meuEscrevedor.println("<br />");
		for (Fruta novaLista : frutaDao.getLista()) {
			meuEscrevedor.println(novaLista.getNome() + " - " + "R$" + novaLista.getPreco() + "!" );
		} */
		meuEscrevedor.println("</body>");
		meuEscrevedor.println("</html>");
	}
}
