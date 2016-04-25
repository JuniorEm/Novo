package br.com.estudo.jdbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Contador
 */
@WebServlet("/contador")
public class Contador extends HttpServlet {
    private int contador = 0;


    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	contador+=10;
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contador++; //A cada requisição para esta servlet, o método service é acessado e há uma contagem
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("O contador agora tem: " + contador);
		out.println("</body>");
		out.println("</html>");
	}
	
	 public void destroy() {
	    	super.destroy();
	   }
	

}
