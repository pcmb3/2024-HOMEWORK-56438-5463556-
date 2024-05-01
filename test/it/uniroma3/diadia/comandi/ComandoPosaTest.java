package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.diadia.IOConsole;
import it.uniroma3.diadia.diadia.Partita;

public class ComandoPosaTest {
	Attrezzo attrezzo = new Attrezzo("nomeAttrezzo", 1);
	Partita partita = new Partita();
	Stanza stanza = new Stanza("s");
	ComandoPosa posa = new ComandoPosa();
	

	@Test
	public void testNessunAttrezzoPosato() {
		posa.setIo(new IOConsole());
		partita.getLabirinto().setStanzaCorrente(stanza);
		posa.setParametro("nomeAttrezzo");
		posa.esegui(partita);
		assertNull(stanza.getAttrezzo("nomeAttrezzo"));
	}
	
	@Test
	public void testAttrezzoPosato() {
		posa.setIo(new IOConsole());
		partita.getLabirinto().setStanzaCorrente(stanza);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		posa.setParametro("nomeAttrezzo");
		posa.esegui(partita);
		assertNotNull(stanza.getAttrezzo("nomeAttrezzo"));
	}


}
