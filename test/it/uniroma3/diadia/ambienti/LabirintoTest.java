package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;

public class LabirintoTest {

	private Labirinto labirinto;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
	      this.labirinto = Labirinto.newBuilder("labirinto.txt").addStanzaIniziale("Atrio").addAttrezzo("osso", 1).addStanzaVincente("Biblioteca").addAdiacenza("Atrio", "Biblioteca", Direzione.valueOf("nord")).getLabirinto();

	}
	
	@Test
	public void testGetStanzaCorrente() {
		Stanza stanzaCorrente = new Stanza("Atrio");
	
		labirinto.setStanzaCorrente(stanzaCorrente);
		assertEquals(stanzaCorrente, labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertNotNull(labirinto.getStanzaVincente());
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}

}
