package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {
	
	Stanza stanzaIniziale = new Stanza("Atrio");
    Stanza stanzaAdiacente = new Stanza("Biblioteca");
	Labirinto labirinto = new Labirinto();
	IO io = new IOSimulator(Arrays.asList("nord"));
	ComandoVai comandoVai = new ComandoVai();
	Partita partita = new Partita(labirinto);


	@Test
	public void testDirezioneInesistente() {
        comandoVai.setIo(io);
		stanzaIniziale.impostaStanzaAdiacente("nord", stanzaAdiacente);
        labirinto.setStanzaCorrente(stanzaIniziale);
        labirinto.setStanzaVincente(stanzaAdiacente);
    
		comandoVai.setParametro("pollo");
		comandoVai.esegui(partita);
		assertNotEquals(stanzaAdiacente, partita.getLabirinto().getStanzaCorrente());

	}

	@Test
	public void testDirezioneEsistente() {
		comandoVai.setIo(io);
		stanzaIniziale.impostaStanzaAdiacente("nord", stanzaAdiacente);
        labirinto.setStanzaCorrente(stanzaIniziale);
        labirinto.setStanzaVincente(stanzaAdiacente);
        
		comandoVai.setParametro("nord");
		comandoVai.esegui(partita);
		assertEquals(stanzaAdiacente, partita.getLabirinto().getStanzaCorrente());

	}
	
}
