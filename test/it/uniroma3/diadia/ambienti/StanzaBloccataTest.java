package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private String nomeAttSblocca = "chiave";
	StanzaBloccata s = new StanzaBloccata("stanza", "sud", nomeAttSblocca);
	Stanza s2 = new Stanza("s2");
	
	@Test
	public void testGetStanzaAdiacenteBloccata() {
		s.impostaStanzaAdiacente("sud", s2);
		assertSame(s, s.getStanzaAdiacente("sud"));

	}
	
	@Test
	public void testGetStanzaAdiacenteSbloccata() {
		Attrezzo  a = new Attrezzo(nomeAttSblocca, 0);
		s.impostaStanzaAdiacente("sud", s2);
		s.addAttrezzo(a);
		assertSame(s2, s.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetDescrizioneBloccata() {
		String descrizioneBloccata = "Questa direzione è bloccata! Per sbloccarla devi posare l'attrezzo" + this.nomeAttSblocca + "nella stanza";
		assertEquals(descrizioneBloccata, s.getDescrizione());
	}

}
