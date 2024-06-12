package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	private Attrezzo a;
	private ComandoPrendi comandoPrendi;
	private Partita par;
	private Stanza s;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		a = new Attrezzo("nomeAttrezzo", 1);
		comandoPrendi = new ComandoPrendi();
		par = new Partita(Labirinto.newBuilder("labirinto.txt").getLabirinto());
		s = new Stanza("stanza");
		par.getLabirinto().setStanzaCorrente(s);
	}
	
	@Test
	public void testNessunAttrezzoPreso() {
		s.addAttrezzo(a);
		comandoPrendi.setParametro("nomeAttrezzo");
		comandoPrendi.esegui(par);
		assertNull(par.getGiocatore().getBorsa().getAttrezzo("Inesistente"));
	}

	@Test
	public void testAttrezzoPreso() {
		s.addAttrezzo(a);
		comandoPrendi.setParametro("nomeAttrezzo");
		comandoPrendi.esegui(par);
		assertNotNull(par.getGiocatore().getBorsa().getAttrezzo("nomeAttrezzo"));
	}

}
