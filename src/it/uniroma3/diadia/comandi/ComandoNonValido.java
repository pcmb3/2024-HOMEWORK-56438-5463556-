package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {

	private IO io;
	
	public ComandoNonValido() {
	}
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Comando non valido!");
	}
	
	public void setIo(IO io) {
	      this.io = io;
	   }

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

}
