package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando{
	
	private static final String MESSAGGIO = "Non c'è nessuno qui";
	private String messaggio;
	private IO io; 
	
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if(personaggio!=null) {
				io.mostraMessaggio(personaggio.saluta());
		} else io.mostraMessaggio(MESSAGGIO);
	}	

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
		return null;
	}
}
