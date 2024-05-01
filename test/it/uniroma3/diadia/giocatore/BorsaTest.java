package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	Attrezzo attrezzo = new Attrezzo("A", 0);
	Borsa borsa = new Borsa();
	
	@Test
	public void testisEmpty() {
		assertTrue(borsa.isEmpty());
	}
	
	@Test
	public void testGetAttrezzo() {
		borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo, borsa.getAttrezzo("A"));
	}

}
