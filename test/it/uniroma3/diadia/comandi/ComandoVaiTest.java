package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {

	private ComandoVai comandoVai;
	private Partita partita;
	private Stanza s1;
	private Stanza s2;

	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		comandoVai = new ComandoVai();
		partita = new Partita(Labirinto.newBuilder("labirinto.txt").getLabirinto());
		s1 = new Stanza("s1");
		s2 = new Stanza("s2");
		comandoVai.setIo(new IOConsole(new Scanner(System.in)));
		}
	
	@Test
	public void testDirezioneInesistente() {
		partita.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente(Direzione.sud, s2);
		comandoVai.setParametro("nord");
		comandoVai.esegui(partita);
		assertNotEquals(s2, partita.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testDirezioneEsistente() {
		partita.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente(Direzione.valueOf("sud"), s2);
		comandoVai.setParametro("sud");
		comandoVai.esegui(partita);
		assertEquals(s2, partita.getLabirinto().getStanzaCorrente());
	}
}
