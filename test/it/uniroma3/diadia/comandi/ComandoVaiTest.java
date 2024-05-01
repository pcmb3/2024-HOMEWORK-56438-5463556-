package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.diadia.IOConsole;
import it.uniroma3.diadia.diadia.Partita;

public class ComandoVaiTest {
	Stanza s1 = new Stanza("s1");
	Stanza s2 = new Stanza("s2");
	ComandoVai comandoVai = new ComandoVai();
	Partita partita = new Partita();
	
	@Test
	public void testDirezioneInesistente() {
		comandoVai.setIo(new IOConsole());
		s1.impostaStanzaAdiacente("sud", s2);
		comandoVai.setParametro("pollo");
		comandoVai.esegui(partita);
		assertNotEquals(s2, partita.getLabirinto().getStanzaCorrente());
		
	}
	
	@Test
	public void testDirezioneEsistente() {
		comandoVai.setIo(new IOConsole());
		partita.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud", s2);
		comandoVai.setParametro("sud");
		comandoVai.esegui(partita);
		assertEquals(s2, partita.getLabirinto().getStanzaCorrente());
		
	}

}
