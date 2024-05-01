package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.diadia.IO;
import it.uniroma3.diadia.diadia.Partita;

public class ComandoFine implements Comando {
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio("Grazie di aver giocato!");
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		return null;
		
	}

	@Override
	public String getParametro() {
		return null;
		
	}

}
