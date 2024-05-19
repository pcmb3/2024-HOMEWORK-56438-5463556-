package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	Attrezzo attrezzo = new Attrezzo("martello", 3);
	Borsa borsa = new Borsa();
	
	@Test
	public void testisEmpty() {
		assertTrue(borsa.isEmpty());
	}
	
	@Test
	public void testGetAttrezzo() {
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
	
	@Test 
	public void testGetContenutoOrdinatoPerPeso() {
		Attrezzo attrezzo2 = new Attrezzo("cuffie", 5);
		List<Attrezzo> ordinatoPerPeso = borsa.getContenutoOrdinatoPerPeso();
		
		ordinatoPerPeso.add(attrezzo);
		ordinatoPerPeso.add(attrezzo2);
		
		assertEquals(3, ordinatoPerPeso.get(0).getPeso());
		assertEquals(5, ordinatoPerPeso.get(1).getPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		Attrezzo attrezzo2 = new Attrezzo("cuffie", 3);
		SortedSet<Attrezzo> ordinatoPerNome = borsa.getContenutoOrdinatoPerNome();

		ordinatoPerNome.add(attrezzo);
		ordinatoPerNome.add(attrezzo2);
		assertEquals(2, ordinatoPerNome.size());
		assertEquals(attrezzo2, ordinatoPerNome.first()); 
		assertEquals(attrezzo, ordinatoPerNome.last());  
	}
	
	
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		Attrezzo attrezzo2 = new Attrezzo("cuffie", 5);
		SortedSet<Attrezzo> ordinatoPerPeso = borsa.getSortedSetOrdinatoPerPeso();

		ordinatoPerPeso.add(attrezzo);
		ordinatoPerPeso.add(attrezzo2);

		Attrezzo[] expected = {attrezzo, attrezzo2};

		int i = 0;
		for (Attrezzo attrezzo : ordinatoPerPeso) {
			assertEquals(expected[i], attrezzo);
			i++;
		} 
	}
	
	@Test 
	public void testGetContenutoRaggruppatoPerPeso() {
		Attrezzo attrezzo2 = new Attrezzo("cuffie", 5);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo2);
		Map<Integer, Set<Attrezzo>> mappa = borsa.getContenutoRaggruppatoPerPeso();
		
		assertTrue(mappa.containsKey(3));
		assertTrue(mappa.containsKey(5));
		
		Set<Attrezzo> attrezzoPeso = mappa.get(3);
        Set<Attrezzo> expectedPeso = new TreeSet<>();
        expectedPeso.add(attrezzo);
        assertEquals(expectedPeso, attrezzoPeso);
        
        Set<Attrezzo> attrezzoPeso2 = mappa.get(5);
        Set<Attrezzo> expectedPeso2 = new TreeSet<>();
        expectedPeso2.add(attrezzo2);
        assertEquals(expectedPeso2, attrezzoPeso2);

	}

}

