package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Cane;
import it.uniroma3.diadia.giocatore.Mago;
import it.uniroma3.diadia.giocatore.Strega;

public class Labirinto{
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	
	private Labirinto() {
	}

	
	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c =	new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
	
	
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaIniziale = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaIniziale;
	}

	public void setStanzaVincente(Stanza sv) {
		this.stanzaVincente = sv;
		
	}	
	
	
	/************ LABIRINTO BUILDER *****************/
	
	public static class LabirintoBuilder{

		private Labirinto labirinto;
		private Stanza ultimaStanzaAggiunta;
		private Map<String, Stanza> stanzaLabirinto;
		

		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		    this.labirinto = new Labirinto();
		    this.stanzaLabirinto= new HashMap<>();
		}

		
		public Map<String, Stanza> getStanzaLabirinto(){
			return this.stanzaLabirinto;
		}
		
		public Labirinto getLabirinto() {
			return this.labirinto;
		}

		public LabirintoBuilder addStanza(String stanza) {
			Stanza s = new Stanza(stanza);
			this.stanzaLabirinto.put(stanza, s);
			this.ultimaStanzaAggiunta(s);
			return this;
		}
		public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
			Stanza iniziale = new Stanza(stanzaIniziale);
			this.labirinto.setStanzaCorrente(iniziale);
			this.stanzaLabirinto.put(stanzaIniziale, iniziale);
			this.ultimaStanzaAggiunta(iniziale);
			return this;
		}
		
		public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiacente, Direzione direzione) {
			Stanza corrente = this.stanzaLabirinto.get(stanzaCorrente);
			Stanza adiacente = this.stanzaLabirinto.get(stanzaAdiacente);
			if(corrente!=null && adiacente !=null) {
			corrente.impostaStanzaAdiacente(direzione, adiacente);	}
			return this;
		}
		
		public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
			Stanza vincente = new Stanza(stanzaVincente);
			this.labirinto.setStanzaVincente(vincente);
			this.stanzaLabirinto.put(stanzaVincente, vincente);
			this.ultimaStanzaAggiunta(vincente);
			return this;
		}
		
		public LabirintoBuilder addStanzaMagica(String stanzaMagica, int soglia) {
			Stanza magica = new StanzaMagica(stanzaMagica, soglia);
			this.stanzaLabirinto.put(stanzaMagica, magica);
			this.ultimaStanzaAggiunta(magica);
			return this;
		}
		
		public LabirintoBuilder addStanzaBloccata(String nome, Direzione direzioneBloccata, String passepartout) {
			Stanza bloccata = new StanzaBloccata(nome, direzioneBloccata, passepartout);
			this.stanzaLabirinto.put(nome, bloccata);
			this.ultimaStanzaAggiunta(bloccata);
			return this;
		}
		
		public LabirintoBuilder addStanzaBuia(String stanzaBuia, String attrezzo) {
			Stanza buia = new StanzaBuia(stanzaBuia, attrezzo);
			//this.stanzaLabirinto.put(attrezzo, buia);
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
		
		public LabirintoBuilder addMago(String nome, String presentazione, Attrezzo attrezzo) {
			Mago mago = new Mago(nome, presentazione, attrezzo);
			this.ultimaStanzaAggiunta.setPersonaggio(mago);
			return this;
		}
		
		public LabirintoBuilder addStrega(String nome, String presentazione) {
			Strega strega = new Strega(nome, presentazione);
			this.ultimaStanzaAggiunta.setPersonaggio(strega);
			return this;
		}
		
		public LabirintoBuilder addCane(String nome, String presentazione) {
			Cane cane = new Cane(nome, presentazione);
			this.ultimaStanzaAggiunta.setPersonaggio(cane);
			return this;
		}

		
		public void ultimaStanzaAggiunta(Stanza ultimaStanzaAggiunta) {
			this.ultimaStanzaAggiunta = ultimaStanzaAggiunta;
			this.stanzaLabirinto.put(ultimaStanzaAggiunta.getNome(), ultimaStanzaAggiunta);
		}

	}

}