package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	private IO io;
	
	public ComandoGuarda () {}
	
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		
		io.mostraMessaggio("Hai ancora: "+ partita.getGiocatore().getCfu() + "CFU");
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


	@Override
	public void setIo(IO io) {
		this.io = io;
		
	}

}
