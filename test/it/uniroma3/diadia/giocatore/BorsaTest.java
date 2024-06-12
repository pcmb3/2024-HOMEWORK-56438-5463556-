package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
public class BorsaTest {

	private Attrezzo attrezzo = new Attrezzo("martello", 3);
	private Borsa borsa = new Borsa();
	
	@Test
	 public void testIsEmpty() {
		assertTrue(borsa.isEmpty());
	}
	
	@Test
	public void  testGetAttrezzo() {
		borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo, borsa.getAttrezzo("martello"));
	}
	

	@Test
	public void testAddAttrezzo() {
		borsa.addAttrezzo(attrezzo);
		assertTrue(borsa.hasAttrezzo("martello"));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		borsa.addAttrezzo(attrezzo);
		borsa.removeAttrezzo("martello");
		assertFalse(borsa.hasAttrezzo("martello"));
	}
	
	@Test
	public void testAttrezziNomeDiversoStessoPeso() {
		Attrezzo attrezzo2 = new Attrezzo("cuffie", 3);
		List<Attrezzo> ordinatoPerPeso = borsa.getContenutoOrdinatoPerPeso();
		
		ordinatoPerPeso.add(attrezzo);
		ordinatoPerPeso.add(attrezzo2);

		assertTrue(ordinatoPerPeso.contains(attrezzo));
	    assertTrue(ordinatoPerPeso.contains(attrezzo2));
	    assertEquals(2, ordinatoPerPeso.size());
	}
	
}
