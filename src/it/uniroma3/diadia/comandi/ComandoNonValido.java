package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.diadia.IO;
import it.uniroma3.diadia.diadia.Partita;

public class ComandoNonValido implements Comando{
	private IO io;

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Comando sconosciuto");
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}



}
