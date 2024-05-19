package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabirintoBuilderTest {
	
	LabirintoBuilder labBuilder = new LabirintoBuilder();
	Stanza stanza = new Stanza("atrio");
	
	@Test
	public void testAddStanza() {
		labBuilder.addStanza("atrio");
		assertNotNull(this.labBuilder.getStanzaLabirinto().containsKey(stanza));
	}
	
	@Test
	public void testAddStanzaIniziale() {
		labBuilder.addStanzaIniziale("atrio");
		assertNotNull(this.labBuilder.getStanzaLabirinto().containsKey(stanza));
	}
	
	@Test
	public void testAddAdiacenza() {
		labBuilder.addStanza("atrio")
				  .addStanza("bagno")
				  .addAdiacenza("atrio", "bagno", "est");
		
		stanza = labBuilder.getStanzaLabirinto().get("atrio");
		assertEquals("bagno", stanza.getStanzaAdiacente("est").getNome());
	}
	
	@Test
	public void testAddAttrezzo() {
		labBuilder.addStanza("corridoio")
				  .addAttrezzo("quadro", 3);
		
		stanza = labBuilder.getStanzaLabirinto().get("corridoio");
		assertEquals("quadro", stanza.getAttrezzo("quadro").getNome());
	}
	
	@Test
	public void testCreaTrilocaleConAttrezzo() {
		labBuilder.addStanza("camera")
			 	  .addStanza("salotto")
			 	  .addAttrezzo("tv", 10)
			 	  .addStanza("cucina")
			 	  .addAttrezzo("microonde", 4)
				  .addStanza("bagno")
				  .addAttrezzo("carta igienica", 8)
				  .addAdiacenza("salotto", "cucina", "ovest")
				  .addAdiacenza("salotto", "bagno", "est");
		
		stanza = labBuilder.getStanzaLabirinto().get("salotto");
		assertEquals("tv", stanza.getAttrezzo("tv").getNome());
		
		
		Stanza bagno = stanza.getStanzaAdiacente("est");
		assertEquals("bagno", bagno.getNome());
		assertEquals("carta igienica", bagno.getAttrezzo("carta igienica").getNome());

		
		Stanza cucina = stanza.getStanzaAdiacente("ovest");
		assertEquals("cucina", cucina.getNome());
		assertEquals("microonde", cucina.getAttrezzo("microonde").getNome());
	}
}

