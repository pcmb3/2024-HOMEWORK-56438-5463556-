package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezzi;


public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>(); // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.numeroAttrezzi++;
		return this.attrezzi.add(attrezzo);
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for (Attrezzo a: attrezzi) {
			if (a.getNome().equals(nomeAttrezzo))
				return a;
		}
		return null;
	}

	public int getPeso() {
		int peso = 0;
		for (Attrezzo a: this.attrezzi)
			peso += a.getPeso();

		return peso;
	}
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null; //all'inizio
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo)) {
				iteratore.remove();
				return a;
			}
		}
		return null;
		/*if(nomeAttrezzo != null) {
			for(int i=0; i<this.numeroAttrezzi; i++) {
				a = this.attrezzi[i];
				if (a!=null && a.getNome().equals(nomeAttrezzo)){
					this.attrezzi[i] = null;
					this.numeroAttrezzi--;
				}
					 
			}
		}
		
		return a;*/
	}
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			/*for (Attrezzo a: attrezzi) {
				s.append(a.toString()+" ");
			}
			*/
			s.append(this.getContenutoOrdinatoPerNome().toString());
			s.append(this.getContenutoRaggruppatoPerPeso().toString());
			s.append(this.getSortedSetOrdinatoPerPeso().toString());
				
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> listaOrdinata = new ArrayList<Attrezzo>(this.attrezzi);
		ComparatoreAttrezzi comp = new ComparatoreAttrezzi();
		Collections.sort(listaOrdinata, comp);
		return listaOrdinata;
	}
	
	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> setOrdinato = new TreeSet<Attrezzo>(new ComparatoreAttrezzi());
		setOrdinato.addAll(this.attrezzi);
		return setOrdinato;
		
		
	}
	
	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> setOrdinato = new TreeSet<Attrezzo>(new ComparatoreAttrezzi());
		setOrdinato.addAll(this.attrezzi);
		return setOrdinato;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
	    Map<Integer, Set<Attrezzo>> mappa = new TreeMap<>();

	    for (Attrezzo attrezzo : this.attrezzi) {
	        int peso = attrezzo.getPeso();
	        Set<Attrezzo> setAttrezzi = mappa.get(peso);
	        if (setAttrezzi == null) {
	            setAttrezzi = new TreeSet<>(new ComparatoreAttrezzi()); // Utilizza TreeSet per l'ordinamento
	            mappa.put(peso, setAttrezzi);
	        }
	        setAttrezzi.add(attrezzo);
	    }

	    return mappa;
	}

}
