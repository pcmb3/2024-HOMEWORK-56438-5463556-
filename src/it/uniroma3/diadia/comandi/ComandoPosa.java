package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	private String nomeAttrezzo;
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(this.nomeAttrezzo);
		if(a != null) {
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		}
		
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}

	@Override
	public String getNome() {
		return nomeAttrezzo;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getParametro() {
		return nomeAttrezzo;
		// TODO Auto-generated method stub
		
	}

	public void setIo(IO io) {
		this.io = io;
		
	}

}
