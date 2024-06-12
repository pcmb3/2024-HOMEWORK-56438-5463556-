package it.uniroma3.diadia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.AbstractPersonaggio;
import it.uniroma3.diadia.giocatore.Cane;
import it.uniroma3.diadia.giocatore.Mago;
import it.uniroma3.diadia.giocatore.Strega;

public class CaricatoreLabirinto {

	private static final String STANZE_MARKER = "Stanze:";             
	private static final String STANZA_INIZIALE_MARKER = "Inizio:";    
	private static final String STANZA_VINCENTE_MARKER = "Vincente:";  
	private static final String STANZA_BUIA_MARKER = "Buia:";  
	private static final String STANZA_BLOCCATA_MARKER = "Bloccata:";  
	private static final String STANZA_MAGICA_MARKER = "Magica:";  
	private static final String MAGO_MARKER = "Mago:";
	private static final String STREGA_MARKER = "Strega:";
	private static final String CANE_MARKER = "Cane:";
	private static final String ATTREZZI_MARKER = "Attrezzi:";
	private static final String USCITE_MARKER = "Uscite:";

	private LineNumberReader reader;
	private Map<String, Stanza> nome2stanza;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
		this.nome2stanza = new HashMap<>();
		this.reader = new LineNumberReader(new FileReader(nomeFile));
	}

	public void carica() throws FormatoFileNonValidoException {
		try {
			this.leggiECreaStanze();
			this.leggiInizialeEvincente();
			this.leggiECreaStanzaMagica();
			this.leggiECreaStanzaBuia();
			this.leggiECreaStanzaBloccata();
			this.leggiECreaMago();
			this.leggiECreaStrega();
			this.leggiECreaCane();
			this.leggiECollocaAttrezzi();
			this.leggiEImpostaUscite();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	private String leggiRigaCheCominciaPer(String marker) throws FormatoFileNonValidoException {
		try {
			String riga = this.reader.readLine();
			check(riga.startsWith(marker), "era attesa una riga che cominciasse per " + marker);
			return riga.substring(marker.length()).trim();
		} catch (IOException e) {
			throw new FormatoFileNonValidoException(e.getMessage());
		}
	}

	private void leggiECreaStanze() throws FormatoFileNonValidoException {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER);
		for (String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
			Stanza stanza = new Stanza(nomeStanza);
			this.nome2stanza.put(nomeStanza, stanza);
		}
	}

	private void leggiECreaStanzaMagica() throws FormatoFileNonValidoException {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZA_MAGICA_MARKER);
		for (String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
			Stanza stanzaMagica = new StanzaMagica(nomeStanza, 3);
			this.nome2stanza.put(nomeStanza, stanzaMagica);
		}
	}

	private void leggiECreaStanzaBloccata() throws FormatoFileNonValidoException {
		String specificheStanze = this.leggiRigaCheCominciaPer(STANZA_BLOCCATA_MARKER);
		if (specificheStanze.isEmpty()) return;
		for (String specifica : separaStringheAlleVirgole(specificheStanze)) {
			try (Scanner scannerDiLinea = new Scanner(specifica)) {
				String nomeStanza = scannerDiLinea.next();
				Direzione direzione = Direzione.valueOf(scannerDiLinea.next().toUpperCase());
				String attrezzoSbloccante = scannerDiLinea.next();
				Stanza stanza = new StanzaBloccata(nomeStanza, direzione, attrezzoSbloccante);
				this.nome2stanza.put(nomeStanza, stanza);
			}
		}
	}

	private void leggiECreaStanzaBuia() throws FormatoFileNonValidoException {
		String specificheStanze = this.leggiRigaCheCominciaPer(STANZA_BUIA_MARKER);
		if (specificheStanze.isEmpty()) return;
		for (String specifica : separaStringheAlleVirgole(specificheStanze)) {
			try (Scanner scannerDiLinea = new Scanner(specifica)) {
				String nomeStanza = scannerDiLinea.next();
				String attrezzoPerVedere = scannerDiLinea.next();
				Stanza stanza = new StanzaBuia(nomeStanza, attrezzoPerVedere);
				this.nome2stanza.put(nomeStanza, stanza);
			}
		}
	}

	private void leggiECreaMago() throws FormatoFileNonValidoException {
		String specifichePersonaggi = this.leggiRigaCheCominciaPer(MAGO_MARKER);
		for (String specifica : separaStringheAlleVirgole(specifichePersonaggi)) {
			try (Scanner scannerDiLinea = new Scanner(specifica)) {
				String nomeStanza = scannerDiLinea.next();
				String nome = scannerDiLinea.next();
				String presentazione = scannerDiLinea.next();
				String nomeAttrezzo = scannerDiLinea.next();
				Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, 1); // Peso hardcoded
				AbstractPersonaggio mago = new Mago(nome, presentazione, attrezzo);
				this.nome2stanza.get(nomeStanza).setPersonaggio(mago);
			}
		}
	}

	private void leggiECreaStrega() throws FormatoFileNonValidoException {
		String specifichePersonaggi = this.leggiRigaCheCominciaPer(STREGA_MARKER);
		for (String specifica : separaStringheAlleVirgole(specifichePersonaggi)) {
			try (Scanner scannerDiLinea = new Scanner(specifica)) {
				String nomeStanza = scannerDiLinea.next();
				String nome = scannerDiLinea.next();
				String presentazione = scannerDiLinea.next();
				AbstractPersonaggio strega = new Strega(nome, presentazione);
				this.nome2stanza.get(nomeStanza).setPersonaggio(strega);
			}
		}
	}

	private void leggiECreaCane() throws FormatoFileNonValidoException {
		String specifichePersonaggi = this.leggiRigaCheCominciaPer(CANE_MARKER);
		for (String specifica : separaStringheAlleVirgole(specifichePersonaggi)) {
			try (Scanner scannerDiLinea = new Scanner(specifica)) {
				String nomeStanza = scannerDiLinea.next();
				String nome = scannerDiLinea.next();
				String presentazione = scannerDiLinea.next();
				AbstractPersonaggio cane = new Cane(nome, presentazione);
				this.nome2stanza.get(nomeStanza).setPersonaggio(cane);
			}
		}
	}

	private List<String> separaStringheAlleVirgole(String string) {
		List<String> result = new LinkedList<>();
		try (Scanner scanner = new Scanner(string)) {
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				result.add(scanner.next().trim());
			}
		}
		return result;
	}

	private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
		String nomeStanzaIniziale = this.leggiRigaCheCominciaPer(STANZA_INIZIALE_MARKER);
		this.stanzaIniziale = this.nome2stanza.get(nomeStanzaIniziale);

		String nomeStanzaVincente = this.leggiRigaCheCominciaPer(STANZA_VINCENTE_MARKER);
		this.stanzaVincente = this.nome2stanza.get(nomeStanzaVincente);
	}

	private void leggiECollocaAttrezzi() throws FormatoFileNonValidoException {
		String specificheAttrezzi = this.leggiRigaCheCominciaPer(ATTREZZI_MARKER);
		for (String specifica : separaStringheAlleVirgole(specificheAttrezzi)) {
			try (Scanner scannerDiLinea = new Scanner(specifica)) {
				String nomeAttrezzo = scannerDiLinea.next();
				String pesoAttrezzo = scannerDiLinea.next();
				String nomeStanza = scannerDiLinea.next();
				Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, Integer.parseInt(pesoAttrezzo));
				this.nome2stanza.get(nomeStanza).addAttrezzo(attrezzo);
			}
		}
	}

	private void leggiEImpostaUscite() throws FormatoFileNonValidoException {
		String specificheUscite = this.leggiRigaCheCominciaPer(USCITE_MARKER);
		for (String specifica : separaStringheAlleVirgole(specificheUscite)) {
			try (Scanner scannerDiLinea = new Scanner(specifica)) {
				String stanzaPartenza = scannerDiLinea.next();
				String direzione = scannerDiLinea.next();
				String stanzaDestinazione = scannerDiLinea.next();
				Stanza stanzaDa = this.nome2stanza.get(stanzaPartenza);
				Stanza stanzaA = this.nome2stanza.get(stanzaDestinazione);
				stanzaDa.impostaStanzaAdiacente(Direzione.valueOf(direzione.toUpperCase()), stanzaA);
			}
		}
	}

	private void check(boolean condizioneCheDeveEssereVera, String messaggioErrore) throws FormatoFileNonValidoException {
		if (!condizioneCheDeveEssereVera)
			throw new FormatoFileNonValidoException(messaggioErrore);
	}

	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
}
