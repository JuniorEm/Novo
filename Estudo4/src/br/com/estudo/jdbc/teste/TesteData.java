package br.com.estudo.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.estudo.jdbc.model.Contato;

public class TesteData {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setDataNascimento(Calendar.getInstance());
		new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime());
	}
}
