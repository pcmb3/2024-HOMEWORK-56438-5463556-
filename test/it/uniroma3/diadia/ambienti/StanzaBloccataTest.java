package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private String passepartout = "chiave";
	private StanzaBloccata stanzaBloccata;
	private Stanza s2;
	
	 @Before
	 public void setUp() {
		stanzaBloccata = new StanzaBloccata("stanza", Direzione.valueOf("sud"), passepartout);
		s2 = new Stanza("s2");
		stanzaBloccata.impostaStanzaAdiacente(Direzione.valueOf("sud"), s2);
	 }
	
	@Test
	public void testGetStanzaAdiacenteBloccata() {
		assertSame(stanzaBloccata, stanzaBloccata.getStanzaAdiacente(Direzione.valueOf("sud")));
	}
	
	@Test
	public void testGetStanzaAdiacenteSbloccata() {
		Attrezzo a = new Attrezzo(passepartout, 0);
		stanzaBloccata.addAttrezzo(a);
		assertSame(s2, stanzaBloccata.getStanzaAdiacente(Direzione.valueOf("sud")));
	}

	@Test
	public void testGetDescrizioneBloccata() {
		String descrizioneBloccata = "Questa direzione è bloccata! Per sbloccarla devi posare l'attrezzo" + this.passepartout + " nella stanza";
		assertEquals(descrizioneBloccata, stanzaBloccata.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSbloccata() {
		Attrezzo attrezzo = new Attrezzo(passepartout, 1);
		stanzaBloccata.addAttrezzo(attrezzo);
		assertEquals(stanzaBloccata.toString(), stanzaBloccata.getDescrizione());
	}
}
