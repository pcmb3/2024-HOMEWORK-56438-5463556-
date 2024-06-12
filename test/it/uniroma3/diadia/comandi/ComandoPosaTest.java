package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertNull;

import java.io.FileNotFoundException;

import org.junit.Before;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

	private Attrezzo a;
	private ComandoPosa comandoPosa;
	private Partita par;
	private Stanza s;
	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		a = new Attrezzo("nomeAttrezzo", 1);
		comandoPosa = new ComandoPosa();
		par = new Partita(Labirinto.newBuilder("labirinto.txt").getLabirinto());
		s = new Stanza("stanza");
		par.getLabirinto().setStanzaCorrente(s);
	}

	@Test
	public void testNessunAttrezzoPosato() {
		comandoPosa.setParametro("nomeAttrezzo");
		comandoPosa.esegui(par);
		assertNull(s.getAttrezzo("nomeAttrezzo"));
	}

	@Test
	public void testAttrezzoPosato() {
		par.getGiocatore().getBorsa().addAttrezzo(a);
		comandoPosa.setParametro("nomeAttrezzo");
		comandoPosa.esegui(par);
		assertNotNull(s.getAttrezzo("nomeAttrezzo"));
	}
}
