package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando{

	private Direzione direzione;
	private IO io;

	public ComandoVai() {
	}

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {

		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;

		if(this.getParametro()==null){
			io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		}
		if(this.getParametro()!=null) {
			prossimaStanza = stanzaCorrente.getStanzaAdiacente(Direzione.valueOf(this.getParametro()));
			if(prossimaStanza==null) {
				io.mostraMessaggio("Direzione inesistente");
				return;
			}
		}

		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}


	public void setIo(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return null;
	}
}
