package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.diadia.IOConsole;
import it.uniroma3.diadia.diadia.Partita;
import it.uniroma3.diadia.giocatore.Borsa;
public class ComandoPrendiTest {
	Attrezzo attrezzo = new Attrezzo("nomeAttrezzo", 1);
	Partita partita = new Partita();
	Stanza stanza = new Stanza("s");
	ComandoPrendi prendi = new ComandoPrendi();
	
	
	@Test
	public void testNessunAttrezzoPreso() {
		prendi.setIo(new IOConsole());
		partita.getLabirinto().setStanzaCorrente(stanza);
		stanza.addAttrezzo(attrezzo);
		prendi.setParametro("nomeAttrezzo");
		prendi.esegui(partita);
		assertNull(partita.getGiocatore().getBorsa().getAttrezzo("inesistente"));
	}
	
	@Test
	public void testAttrezzoPreso() {
		prendi.setIo(new IOConsole());
		partita.getLabirinto().setStanzaCorrente(stanza);
		stanza.addAttrezzo(attrezzo);
		prendi.setParametro("nomeAttrezzo");
		prendi.esegui(partita);
		assertNull(partita.getGiocatore().getBorsa().getAttrezzo("nomeAttrezzo"));
	}

}
