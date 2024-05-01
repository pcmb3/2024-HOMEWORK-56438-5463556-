package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	StanzaBuia buia = new StanzaBuia("stanza", "s");
	
	@Test
	public void attrezzoMancanteTest() {
		String buio = "qui c'è un buio pesto"; 
		assertEquals(buio, buia.getDescrizione());
	}
	
	@Test
	public void attrezzoPresenteTest() {
		Attrezzo attrezzo = new Attrezzo("nomeAttrezzo", 0);
		buia.addAttrezzo(attrezzo);
		assertEquals("qui c'è un buio pesto", buia.getDescrizione());
	}
}
