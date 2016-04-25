package br.com.juniorsite.jdbc.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.juniorsite.jdbc.ConnectionFactory;
import br.com.juniorsite.jdbc.model.Contato;

public class ContatoDao {
	private Connection connection;
	
	public ContatoDao() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionaContato(Contato contato) {
		String sql = "insert into contato (imagem, nome, email, telefone, dataNascimento, texto) values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, contato.getImagem());
			statement.setString(2, contato.getNome());
			statement.setString(3, contato.getEmail());
			statement.setString(4, contato.getTelefone());
			statement.setDate(5, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
			statement.setString(6, contato.getTexto());
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Impossível realizar ação de inserção no Banco de Dados");
		}
	}
	
	public List<Contato> getLista() {
		String sql = "select * from contato";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			List<Contato> lista = new ArrayList<>();
			
			while (resultSet.next()) {
				Contato contato = new Contato();
				contato.setId(resultSet.getInt("id"));
				contato.setImagem(resultSet.getString("imagem"));
				contato.setNome(resultSet.getString("nome"));
				contato.setEmail(resultSet.getString("email"));
				contato.setTelefone(resultSet.getString("telefone"));
				Date date = resultSet.getDate("dataNascimento");
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				contato.setDataNascimento(calendar);
				contato.setTexto(resultSet.getString("texto"));
				lista.add(contato);
			}
			
			statement.close();
			connection.close();
			
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException("Impossível realizar busca no Banco de Dados", e);
		}
	}
	
	public void altera(Contato contato) {
		String sql = "update contato set imagem = ?, nome = ?, email = ?, telefone = ?, dataNascimento = ?, texto = ? where id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, contato.getImagem());
			statement.setString(2, contato.getNome());
			statement.setString(3, contato.getEmail());
			statement.setString(4, contato.getTelefone());
			statement.setDate(5, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
			statement.setString(6, contato.getTexto());
			statement.setInt(7, contato.getId());
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Impossível realizar ação de inserção no Banco de Dados");
		}
	}
	
	public Contato buscaContato(int id) {
		String sql = "select * from contato where id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			Contato contato = new Contato();
			
			if (resultSet.next()) {
				contato.setImagem(resultSet.getString("imagem"));
				contato.setNome(resultSet.getString("nome"));
				contato.setEmail(resultSet.getString("email"));
				contato.setTelefone(resultSet.getString("telefone"));
				Date date = resultSet.getDate("dataNascimento");
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				contato.setDataNascimento(calendar);
				contato.setTexto(resultSet.getString("texto"));
			}
			
			return contato;
		} catch (SQLException e) {
			throw new RuntimeException("Houve um erro de busca!", e);
		}
	}
	
	public void exclui(int id) {
		try {
			PreparedStatement statement = connection.prepareStatement("delete from contato where id = ?");
			statement.setInt(1, id);
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível realizar a exclusão!");
		}

	}
}
