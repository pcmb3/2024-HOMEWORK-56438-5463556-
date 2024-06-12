package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;


public class ComandoAiuto extends AbstractComando {

	static final private String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "interagisci", "saluta", "regala", "aiuto", "fine"};
	private IO io;
	
	public ComandoAiuto() {
	}
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
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
