package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private IO io;
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
		if(a!=null) {
		partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
		partita.getGiocatore().getBorsa().addAttrezzo(a);
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "prendi";
	}

	public void setIo(IO io) {
	      this.io = io;
	   }
}
