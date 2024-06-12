package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.Configuratore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = Configuratore.getPesoMax();
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
		if(attrezzi.add(attrezzo)) {
			numeroAttrezzi++;
			return true;
		}
			
		return false;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for (Attrezzo a : attrezzi) {
			if (a.getNome().equals(nomeAttrezzo))
				return a;
		}
		return null;
	}
	
	public int getPeso() {
		int peso = 0;
		for (Attrezzo a : this.attrezzi)
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
		Attrezzo a = null;

		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo)) {
				iteratore.remove();
				return a;
			}
		}
		return null;
	}
	
	public String toString() {
	      StringBuilder s = new StringBuilder();
	      if (!this.isEmpty()) {
	         s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
	         s.append("\n");
	         s.append(this.getContenutoOrdinatoPerNome().toString());
//	         s.append("\n");
//	         s.append(this.getContenutoRaggruppatoPerPeso().toString());
//	         s.append("\n");
//	         s.append(this.getSortedSetOrdinatoPerPeso().toString());
	      } else {
	         s.append("Borsa vuota");
	      }

	      return s.toString();
	   }

	
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> listaOrdinata = new ArrayList<Attrezzo>(this.attrezzi);
		ComparatoreAttrezzi comparatore = new ComparatoreAttrezzi();
		Collections.sort(listaOrdinata, comparatore);
		return listaOrdinata;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> setOrdinato = new TreeSet<>(new ComparatoreAttrezzi());
		setOrdinato.addAll(this.attrezzi);
		return setOrdinato;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
	    Map<Integer, Set<Attrezzo>> mappa = new TreeMap<>();

	    for (Attrezzo attrezzo : this.attrezzi) {
	        int peso = attrezzo.getPeso();
	        Set<Attrezzo> setAttrezzi = mappa.get(peso);
	        if (setAttrezzi == null) {
	            setAttrezzi = new TreeSet<>(new ComparatoreAttrezzi()); 
	            mappa.put(peso, setAttrezzi);
	        }
	        setAttrezzi.add(attrezzo);
	    }
	    return mappa;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> setOrdinato = new TreeSet<>(new ComparatoreAttrezzi());
		setOrdinato.addAll(this.attrezzi);
		return setOrdinato;
	}
}