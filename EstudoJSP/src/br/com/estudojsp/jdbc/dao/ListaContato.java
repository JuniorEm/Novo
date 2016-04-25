package br.com.estudojsp.jdbc.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.estudojsp.jdbc.modelo.Contato;

public class ListaContato {
	private List<Contato> contatos = new ArrayList<>();
	private static ListaContato lista;
	
	private ListaContato() {}
	
	public static ListaContato getInstance() {
		if (lista == null)
			lista = new ListaContato();
		return lista;
	}
	public void adiciona(Contato contato) {
		contatos.add(contato);
	}
	
	public List<Contato> getLista() {
		return contatos;
	}
}
