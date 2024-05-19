package it.uniroma3.diadia.ambienti;


import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder{

	private Labirinto labirinto;
	private Stanza ultimaStanzaAggiunta;
	private Map<String, Stanza> stanzaLabirinto = new HashMap<>();


	public LabirintoBuilder() {
		this.labirinto= new Labirinto();
	}

	public Map<String, Stanza> getStanzaLabirinto(){
		return this.stanzaLabirinto;
	}

	public Labirinto getLabirinto() {
		return labirinto;
	}

	public LabirintoBuilder addStanza(String stanza) {
		Stanza s = new Stanza(stanza);
		this.stanzaLabirinto.put(stanza, s);
		this.ultimaStanzaAggiunta(s);
		return this;
	}
	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza iniziale = new Stanza(stanzaIniziale);
		this.getLabirinto().setStanzaCorrente(iniziale);
		this.stanzaLabirinto.put(stanzaIniziale, iniziale);
		this.ultimaStanzaAggiunta(iniziale);
		return this;
	}

	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiacente, String direzione) {
		Stanza corrente = this.stanzaLabirinto.get(stanzaCorrente);
		Stanza adiacente = this.stanzaLabirinto.get(stanzaAdiacente);
		if(corrente!=null && adiacente !=null) {
			corrente.impostaStanzaAdiacente(direzione, adiacente);	
		}
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza vincente = new Stanza(stanzaVincente);
		this.getLabirinto().setStanzaVincente(vincente);
		this.stanzaLabirinto.put(stanzaVincente, vincente);
		this.ultimaStanzaAggiunta(vincente);
		return this;
	}

	public LabirintoBuilder addStanzaMagice(String stanzaMagica, int soglia) {
		Stanza magica = new StanzaMagica(stanzaMagica, soglia);
		this.stanzaLabirinto.put(stanzaMagica, magica);
		this.ultimaStanzaAggiunta(magica);
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String nome, String direzioneBloccata, String passepartout) {
		Stanza bloccata = new StanzaBloccata(nome, direzioneBloccata, passepartout);
		this.stanzaLabirinto.put(nome, bloccata);
		this.ultimaStanzaAggiunta(bloccata);
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String stanzaBuia, String attrezzo) {
		Stanza buia = new StanzaBuia(stanzaBuia, attrezzo);
		this.stanzaLabirinto.put(attrezzo, buia);
		this.ultimaStanzaAggiunta(buia);
		return this;
	}

	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
		Attrezzo a = new Attrezzo(attrezzo, peso);
		if (this.ultimaStanzaAggiunta != null) {
			this.ultimaStanzaAggiunta.addAttrezzo(a);
		}
		return this;
	}


	public void ultimaStanzaAggiunta(Stanza ultimaStanzaAggiunta) {
		this.ultimaStanzaAggiunta = ultimaStanzaAggiunta;
		this.stanzaLabirinto.put(ultimaStanzaAggiunta.getNome(), ultimaStanzaAggiunta);
	}

}