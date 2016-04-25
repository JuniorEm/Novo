package br.com.estudo.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estudo.jdbc.ConnectionFactory;
import br.com.estudo.jdbc.model.Funcionario;

public class FuncionarioDao {
	private Connection connection;
	
	public FuncionarioDao() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Funcionario funcionario) {
		String sql = "insert into funcionario (nome, usuario, senha) values (?, ?, ?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getUsuario());
			statement.setString(3, funcionario.getSenha());
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao inserir no Banco", e);
		}
	}
	
	public List<Funcionario> getLista() {
		String sql = "select * from funcionario";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			List<Funcionario> listaFuncionario = new ArrayList<>();
			
			while (resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(resultSet.getInt("id"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setUsuario(resultSet.getString("usuario"));
				funcionario.setSenha(resultSet.getString("senha"));
				
				listaFuncionario.add(funcionario);
			}
			
			statement.close();
			connection.close();
			
			return listaFuncionario;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar no Banco de Dados!", e);
		}
		
		
	}
}
