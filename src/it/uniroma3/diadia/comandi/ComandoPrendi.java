package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private String nomeAttrezzo;
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
		if(a != null) {
			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
			partita.getGiocatore().getBorsa().addAttrezzo(a);
		}
		
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}

	@Override
	public String getNome() {
		return nomeAttrezzo;
	}

	@Override
	public String getParametro() {
		return nomeAttrezzo;	
	}
	
	public void setIo(IO io) {
		this.io = io;
	}
	
}
