package it.uniroma3.diadia;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	Labirinto labirinto = new Labirinto();
	
	@Test
	public void testGetStanzaVincente() {
		
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testGetStanzaCorrente() {
		Stanza stanzaCorrente = new Stanza("Atrio");
		labirinto.setStanzaCorrente(stanzaCorrente);
		assertEquals(stanzaCorrente, labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testIsFinita() {
		Partita partita = new Partita();
		assertFalse(partita.isFinita());
	}
}
