package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private boolean finita;
	private Giocatore giocatore;
	private Labirinto labirinto;
	
	public Partita(){
		this.giocatore = new Giocatore();
		this.labirinto = new Labirinto();
		this.finita = false;
	}

    
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return labirinto.getStanzaCorrente()== labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.getGiocatore().getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}



	public Giocatore getGiocatore() {
		return giocatore;
	}



	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}



	public Labirinto getLabirinto() {
		return labirinto;
	}



	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
}
