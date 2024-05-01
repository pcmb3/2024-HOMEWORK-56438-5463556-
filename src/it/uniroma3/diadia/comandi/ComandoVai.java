package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.diadia.IO;
import it.uniroma3.diadia.diadia.IOConsole;
import it.uniroma3.diadia.diadia.Partita;

public class ComandoVai implements Comando{
	private String direzione;
	private IO io;
	
	public ComandoVai() {
	}
	

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione == null) {
			io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza == null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}


	@Override
	public String getNome() {
		return direzione;
		
	}


	@Override
	public String getParametro() {
		return direzione;
		
	}


	public void setIo(IO io) {
		this.io = io;
		
	}

}
