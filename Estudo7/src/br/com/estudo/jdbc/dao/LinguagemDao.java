package br.com.estudo.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.estudo.jdbc.ConnectionFactory;
import br.com.estudo.jdbc.exception.DAOException;
import br.com.estudo.jdbc.model.Linguagem;

public class LinguagemDao {
	private Connection connection;
	
	public LinguagemDao() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Linguagem linguagem) {
		try {
			PreparedStatement statement = connection.prepareStatement("insert into linguagem (nome, reputacao, data) values (?, ?, ?)");
			statement.setString(1, linguagem.getNome());
			statement.setInt(2, linguagem.getReputacao());
			//O objeto sql.Date quer um "long" em seu construtor, e o método getTimeInMillis retorna o tempo em long
			//Que são os millisegundos
			statement.setDate(3, new Date(linguagem.getData().getTimeInMillis()));
			
			statement.execute(); //É necessário carregar o statement e somente depois executá-lo
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new DAOException("Impossível adicionar no Banco!", e);
		}
	}
	
	public List<Linguagem> getLista() {
		try {
			PreparedStatement statement = connection.prepareStatement("select * from linguagem");
			ResultSet result = statement.executeQuery();
			List<Linguagem> lista = new ArrayList<>();
			
			while (result.next()) {
				Linguagem linguagem = new Linguagem();
				linguagem.setId(result.getLong("id"));
				linguagem.setNome(result.getString("nome"));
				linguagem.setReputacao(result.getInt("reputacao"));
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(result.getDate("data")); //Set Time pode receber um date do tipo util.Date ou sql.Date
				linguagem.setData(calendar);
				lista.add(linguagem);
			}
			
			statement.close();
			connection.close();
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar no Banco!", e);
		}
	}
	
	public List<Linguagem> getListaRefinada(String nome) {
		String sql = "select * from linguagem where nome like ?" ;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + nome + "%");
			statement.execute();
			
			ResultSet result = statement.executeQuery();
			List<Linguagem> lista = new ArrayList<>();
			
			while (result.next()) {
				Linguagem linguagem = new Linguagem();
				linguagem.setId(result.getLong("id"));
				linguagem.setNome(result.getString("nome"));
				linguagem.setReputacao(result.getInt("reputacao"));
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(result.getDate("data"));
				linguagem.setData(calendar);
				
				lista.add(linguagem);
			}
			
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar no Banco com parâmetro especificado", e);
		}
	}
	
	public Linguagem pesquisa(int id) {
		String sql = "select * from linguagem where id = ?";
		try {
			Linguagem linguagem = null;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				linguagem = new Linguagem();
				linguagem.setId(result.getLong("id"));
				linguagem.setNome(result.getString("nome"));
				linguagem.setReputacao(result.getInt("reputacao"));
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(result.getDate("data"));
				linguagem.setData(calendar);
			}
			
			return linguagem;
		} catch (SQLException e) {
			throw new RuntimeException("Objeto com parâmetro especificado: Não encontrado!", e);
		}
	}
}
