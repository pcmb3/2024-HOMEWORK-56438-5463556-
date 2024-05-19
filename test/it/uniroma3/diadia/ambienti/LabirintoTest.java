package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	Labirinto labirinto = new Labirinto();
	
	@Test
	public void testGetStanzaVincente() {
		this.labirinto = Labirinto.newBuilder()
				 .addStanzaIniziale("Atrio")
				 .addAttrezzo("osso", 1)
				 .addStanzaVincente("Biblioteca")
				 .addAdiacenza("Atrio", "Biblioteca", "nord")
				 .getLabirinto();
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testGetStanzaCorrente() {
		Stanza stanzaCorrente = new Stanza("Atrio");
		labirinto.setStanzaCorrente(stanzaCorrente);
		assertEquals(stanzaCorrente, labirinto.getStanzaCorrente());
	}
	
}
