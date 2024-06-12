package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {

	private IO io;
	private static final String NOME = "guarda";

	
	public ComandoGuarda() {
	}
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		io.mostraMessaggio("Hai ancora "+ partita.getGiocatore().getCfu() + " CFU");
	}

	
	
	public void setIo(IO io) {
	      this.io = io;
	   }
	
	@Override
	public String getNome() {
		return "guarda";
	}

}
