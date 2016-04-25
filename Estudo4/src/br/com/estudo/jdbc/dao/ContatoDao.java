package br.com.estudo.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.estudo.jdbc.ConnectionFactory;
import br.com.estudo.jdbc.model.Contato;

public class ContatoDao {
	private Connection connection;
	
	public ContatoDao() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contato (nome, email, endereco, dataNascimento) values (?, ?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getEmail());
			statement.setString(3, contato.getEndereco());
			statement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro inesperado ao gravar no Banco!", e);
		}
	}
	
	public List<Contato> getLista() {
		String sql = "select * from contato";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			List<Contato> listaContato = new ArrayList<>();
			
			while (result.next()) {
				Contato contato = new Contato();
				contato.setId(result.getInt("id"));
				contato.setNome(result.getString("nome"));
				contato.setEmail(result.getString("email"));
				contato.setEndereco(result.getString("endereco"));
				Date date = result.getDate("dataNascimento");
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				contato.setDataNascimento(calendar);
				
				listaContato.add(contato);
			}
			
			statement.close();
			connection.close();
			
			return listaContato;
		} catch (SQLException e) {
			throw new RuntimeException("Impossível realizar coleta de dados do Banco", e);
		}
	}
}
