package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {

	private IO io; 
	
	public ComandoFine() {
	}
	
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio("Grazie di aver giocato!");
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
