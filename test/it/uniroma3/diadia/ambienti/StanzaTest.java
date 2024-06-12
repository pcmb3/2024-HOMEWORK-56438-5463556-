package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;


import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	@Test
	public void testDtanzaVuota() {
		Stanza vuota = new Stanza("vuota");
		assertNull(vuota.getAttrezzo("inesistente"));
	}
	
	@Test
	public void testGetAttrezziPresente() {
		Stanza stanza = new Stanza("nonvuota");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		assertNotNull(stanza.getAttrezzi());
	}
	
	@Test
	public void testGetStanzaAdiacente() {
		Stanza s1 = new Stanza("s1");
		Stanza s2 = new Stanza("s2");
		s1.impostaStanzaAdiacente(Direzione.valueOf("sud"), s2);
		assertNotNull(s1.getStanzaAdiacente(Direzione.valueOf("sud")));
	}
	
	@Test
	public void testAddAttrezzo() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("martello", 3);
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo("martello"));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("martello", 3);
		stanza.addAttrezzo(attrezzo);
		stanza.removeAttrezzo(attrezzo);
		assertFalse(stanza.hasAttrezzo("martello"));
	}

}
