package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

public class LabirintoBuilderTest {

	private Labirinto.LabirintoBuilder labBuilder;
	private Stanza stanza;

	@Before
	public void setUp() throws Exception {
		this.labBuilder = new LabirintoBuilder("labirinto.txt");
		this.stanza = new Stanza("atrio");
	}
	
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
				  .addAdiacenza("atrio", "bagno", Direzione.valueOf("est"));
		
		stanza = labBuilder.getStanzaLabirinto().get("atrio");
		assertEquals("bagno", stanza.getStanzaAdiacente(Direzione.valueOf("est")).getNome());
	}
	
	@Test
	public void testAddAttrezzo() {
		labBuilder.addStanza("corridoio")
				  .addAttrezzo("quadro", 3);
		
		stanza = labBuilder.getStanzaLabirinto().get("corridoio");
		assertEquals("quadro", stanza.getAttrezzo("quadro").getNome());
	}
	
	@Test
	public void testCreaTrilocaleConAttrezzi() {
		labBuilder.addStanza("camera")
			 	  .addStanza("salotto")
			 	  .addAttrezzo("tv", 10)
			 	  .addStanza("cucina")
			 	  .addAttrezzo("microonde", 4)
				  .addStanza("bagno")
				  .addAttrezzo("carta igienica", 8)
				  .addAdiacenza("salotto", "cucina", Direzione.valueOf("ovest"))
				  .addAdiacenza("salotto", "bagno", Direzione.valueOf("est"));
		
		stanza = labBuilder.getStanzaLabirinto().get("salotto");
		assertEquals("tv", stanza.getAttrezzo("tv").getNome());
		
		
		Stanza bagno = stanza.getStanzaAdiacente(Direzione.valueOf("est"));
		assertEquals("bagno", bagno.getNome());
		assertEquals("carta igienica", bagno.getAttrezzo("carta igienica").getNome());

		
		Stanza cucina = stanza.getStanzaAdiacente(Direzione.valueOf("ovest"));
		assertEquals("cucina", cucina.getNome());
		assertEquals("microonde", cucina.getAttrezzo("microonde").getNome());
	}
}
