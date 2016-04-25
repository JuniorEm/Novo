package br.com.estudo.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estudo.jdbc.ConnectionFactory;
import br.com.estudo.jdbc.model.Fruta;

public class FrutaDao {
	private Connection connection;
	
	public FrutaDao() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Fruta fruta) {
		String sql = "insert into fruta (nome, preco) values (?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, fruta.getNome());
			statement.setDouble(2, fruta.getPreco());
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Impossível inserir dados no Banco!", e);
		}
	}
	
	public List<Fruta> getLista() {
		String sql = "select * from fruta";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery(); //Return all the rows from the specified table
			//ExecuteQuery retorna
			List<Fruta> lista = new ArrayList<>();
			
			while(result.next()) {
				Fruta fruta = new Fruta(); //It construct the object to show all the results
				fruta.setNome(result.getString("nome"));
				fruta.setPreco(result.getDouble("preco"));
				lista.add(fruta);
			}
			
			statement.close();
			connection.close();
			
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException("Erro no retorno dos resultados", e);
		}
	}
	
}
