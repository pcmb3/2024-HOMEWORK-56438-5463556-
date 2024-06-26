package it.uniroma3.diadia.giocatore;

import java.util.Comparator;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComparatoreAttrezzi implements Comparator<Attrezzo>{

	public ComparatoreAttrezzi() {
	}
	
	public int compare(Attrezzo a1, Attrezzo a2) {
		if (a1.getPeso()-a2.getPeso()==0)
			return a1.getNome().compareTo(a2.getNome());
		else
			return a1.getPeso()-a2.getPeso();
	}
}
