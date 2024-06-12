package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private static final int sogliaMagica = 3;
	private StanzaMagica magica;
	Attrezzo attrezzo;

	@Before
	public void setUp() {
		magica = new StanzaMagica("Atrio", sogliaMagica);
		attrezzo = new Attrezzo("bacchetta magica", 5);
	}
	
	@Test
	public void testAddAttrezzo() {
		magica.addAttrezzo(attrezzo);
		assertEquals(attrezzo, magica.getAttrezzo("bacchetta magica"));
	}
	
	@Test
	public void testModificaAttrezzo() {
		magica.addAttrezzo(attrezzo);
		Attrezzo invertito = magica.modificaAttrezzo(attrezzo);
		assertEquals("acigam attehccab", invertito.getNome());
	}
	
	@Test
	public void testSogliaNonSuperata() {
		Attrezzo attrezzo1 = new Attrezzo("falce", 3);
		Attrezzo attrezzo2 = new Attrezzo("candela", 2);

		magica.addAttrezzo(attrezzo);
		magica.addAttrezzo(attrezzo1);
		magica.addAttrezzo(attrezzo2);
		
		assertEquals("candela", attrezzo2.getNome());
		assertNull(magica.getAttrezzo("alednac"));
		
	}
	
	@Test
	public void testSogliaSuperata() {
		Attrezzo attrezzo1 = new Attrezzo("falce", 3);
		Attrezzo attrezzo2 = new Attrezzo("candela", 2);
		Attrezzo attrezzo3 = new Attrezzo("tazza", 4);
		
		magica.addAttrezzo(attrezzo);
		magica.addAttrezzo(attrezzo1);
		magica.addAttrezzo(attrezzo2);
		magica.addAttrezzo(attrezzo3);
		
		Attrezzo invertito = magica.getAttrezzo("azzat");
		assertEquals(8, invertito.getPeso());
		assertEquals("azzat", invertito.getNome());
		assertNotEquals(4, invertito.getPeso());
		assertNotEquals("tazza", invertito.getNome());
	}
}
