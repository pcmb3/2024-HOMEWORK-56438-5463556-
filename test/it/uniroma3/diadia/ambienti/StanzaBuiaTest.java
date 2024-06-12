package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaBuiaTest {

	private StanzaBuia stanzaBuia;
	private Attrezzo a;
	
	@Before
	public void setUp() {
       stanzaBuia = new StanzaBuia("stanzaBuia", "lampadina");
       a = new Attrezzo("lampadina", 0);
    }
	
	@Test
	public void testAttrezzoMancante() {
		assertEquals("Qui c'è buio pesto", stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testAttrezzoPresente() {
		stanzaBuia.addAttrezzo(a);
		assertEquals(stanzaBuia.toString(), stanzaBuia.getDescrizione());
	}
}
