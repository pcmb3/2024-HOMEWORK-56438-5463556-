package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Configuratore;

public class Giocatore {

	static final private int CFU_INIZIALI = Configuratore.getCFU();
	private int cfu;
	private Borsa borsa;
	
	public Giocatore() {
		this.borsa = new Borsa();
		this.cfu = CFU_INIZIALI;
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	public Borsa getBorsa() {
		return borsa;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}	
}
