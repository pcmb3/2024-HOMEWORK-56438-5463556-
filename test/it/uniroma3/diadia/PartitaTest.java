package it.uniroma3.diadia;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	Labirinto labirinto;
	Partita partita;
	Stanza stanza;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		labirinto = Labirinto.newBuilder("labirinto1.txt").getLabirinto();
		partita = new Partita(labirinto);
		stanza = new Stanza("Stanza");
	}

	@Test
	public void testGetStanzaCorrente() {
		Stanza stanzaCorrente = new Stanza("Atrio");

		labirinto.setStanzaCorrente(stanzaCorrente);
		assertEquals(stanzaCorrente, labirinto.getStanzaCorrente());
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}

	@Test
	public void testIsFinita() {
		assertFalse(partita.isFinita());
	}	
}