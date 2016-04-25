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

import br.com.estudo.jdbc.dao.FuncionarioDao;
import br.com.estudo.jdbc.model.Funcionario;

@WebServlet(name = "AdicionaFuncionario", urlPatterns = { "/addFuncionario.php", "/adicionaFuncionario" },
initParams = { 
		@WebInitParam(name = "parametro1", value = "NodeJs"),
		@WebInitParam(name = "parametro2", value = "JQuery")}
) 
public class AdicionaFuncionarioServlet extends HttpServlet {
	private String parametro1;
	private String parametro2;
	
	public void init(ServletConfig config) throws ServletException { //inicializa a Servlet
		super.init(config);
		parametro1 = config.getInitParameter("parametro1");
		parametro2 = config.getInitParameter("parametro2");
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Response é a informação que o servidor trás para o navegador!");
		out.println("Você vai aprender " + parametro1 + " e " + parametro2);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(request.getParameter("nome"));
		funcionario.setUsuario(request.getParameter("usuario"));
		funcionario.setSenha(request.getParameter("senha"));
		
		FuncionarioDao dao = new FuncionarioDao();
		dao.adiciona(funcionario);

	}
	
	public void destroy() {
		super.destroy();
	}

	

}
