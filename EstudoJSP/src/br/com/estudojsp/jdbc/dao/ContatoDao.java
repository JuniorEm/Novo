package br.com.estudojsp.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.estudojsp.jdbc.ConnectionFactory;
import br.com.estudojsp.jdbc.modelo.Contato;

public class ContatoDao {
	private Connection connection;
	
	public ContatoDao() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		try {
			PreparedStatement statement = connection.prepareStatement("insert into contato (nome, email, dataNascimento)"
					+ "values (?, ?, ?)");
			
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getEmail());
			statement.setDate(3, new Date(contato.getDataNascimento().getTimeInMillis()));
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Impossível adicionar no Banco de Dados");
		}
	}
	
	public void altera(Contato contato) {
		try {
			PreparedStatement statement = connection.prepareStatement("update contato set nome=?, email=?, dataNascimento=?"
					+ "where id=?");
			
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getEmail());
			statement.setDate(3, new Date(contato.getDataNascimento().getTimeInMillis()));
			statement.setInt(4, contato.getId());
			
			statement.execute();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException("Impossível realizar alteração!");
		}
	}
	
	public List<Contato> getLista() {
		try {
			PreparedStatement statement = connection.prepareStatement("select * from contato");
			ResultSet rowReturned = statement.executeQuery();
			List<Contato> listaContato = new ArrayList<>();
			
			while (rowReturned.next()) {
				Contato contato = new Contato();
				contato.setId(rowReturned.getInt("id"));
				contato.setNome(rowReturned.getString("nome"));
				contato.setEmail(rowReturned.getString("email"));
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rowReturned.getDate("dataNascimento"));
				contato.setDataNascimento(calendar);
	
				listaContato.add(contato);
			}
			
			statement.close();
			connection.close();
			
			return listaContato;
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao buscar no Banco!", e);
		}
	}
	
	public List<Contato> getListaEspecifica(String chavePesquisa) {
		try {
			PreparedStatement statement = connection.prepareStatement("select * from contato where nome like '%" + chavePesquisa + "%'");
			ResultSet rowReturned = statement.executeQuery();
			List<Contato> listaContato = new ArrayList<>();
			
			while (rowReturned.next()) {
				Contato contato = new Contato();
				contato.setId(rowReturned.getInt("id"));
				contato.setNome(rowReturned.getString("nome"));
				contato.setEmail(rowReturned.getString("email"));
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rowReturned.getDate("dataNascimento"));
				contato.setDataNascimento(calendar);
	
				listaContato.add(contato);
			}
			
			statement.close();
			connection.close();
			
			return listaContato;
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao buscar no Banco!", e);
		}
	}
	
	
	public Contato getContato(int id) {
		try {
			PreparedStatement prepare = connection.prepareStatement("select * from contato where id = " + id);
			ResultSet rowReturned = prepare.executeQuery();
			Contato contato = new Contato();
			
			if (rowReturned.next()) {
				contato.setId(rowReturned.getInt("id"));
				contato.setNome(rowReturned.getString("nome"));
				contato.setEmail(rowReturned.getString("email"));
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rowReturned.getDate("dataNascimento"));
				contato.setDataNascimento(calendar);
			}
			
			prepare.close();
			connection.close();
			
			return contato;
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao retornar contato!");
		}
	}
}
