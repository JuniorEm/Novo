package br.com.estudo.jdbc.teste;

import br.com.estudo.jdbc.dao.FuncionarioDao;
import br.com.estudo.jdbc.model.Funcionario;

public class TesteBanco {
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Ailton Aparecido Bezerra Junior");
		funcionario.setUsuario("admin");
		funcionario.setSenha("admin");
		
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Daniel Henrique Green");
		funcionario2.setUsuario("hazoccc");
		funcionario2.setSenha("hazocc123");
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		
		for (Funcionario funcionarioLista : funcionarioDao.getLista()) {
			System.out.println("\n" + funcionarioLista.getId());
			System.out.println(funcionarioLista.getNome());
			System.out.println(funcionarioLista.getUsuario());
			System.out.println(funcionarioLista.getSenha());
		}
		
		funcionarioDao.adiciona(funcionario2);
	}
}
