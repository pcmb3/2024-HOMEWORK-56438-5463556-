package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	@Test
	public void testStanzaVuota() {
		Stanza vuota = new Stanza("vuota");
		assertNull(vuota.getAttrezzo("inesistente"));
	}
	
	@Test
	public void testGetAttrezziPresente() {
		Stanza stanza = new Stanza ("nonvuota");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		assertNotNull(stanza.getAttrezzi());
	}
	
	@Test
	public void testGetStanzaAdiacente() {
		Stanza s1 = new Stanza("s1");
		Stanza s2 = new Stanza("s2");
		s1.impostaStanzaAdiacente("sud", s2);
		assertNotNull(s1.getStanzaAdiacente("sud"));
	}
}
