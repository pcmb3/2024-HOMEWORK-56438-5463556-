package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	public static final String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;
	private IO io;

	public DiaDia(Labirinto labirinto, IO console) {
		this.partita = new Partita(labirinto);
		this.io = console;
	}

	public void gioca() throws Exception {
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 * @throws Exception 
	 */
	private boolean processaIstruzione(String istruzione) throws Exception {
		Comando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva(this.io);

		try {
		comandoDaEseguire = factory.costruisciComando(istruzione);
		} 
		catch(ClassNotFoundException cne) {
		comandoDaEseguire = factory.costruisciComando("NonValido");
		} 
		catch(NullPointerException npe) {
			comandoDaEseguire = factory.costruisciComando("NonValido");
		}
		
		comandoDaEseguire.esegui(this.partita);
		
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	public static void main(String[] argc) throws Exception {
		Scanner scanner = new Scanner(System.in);
		IO io = new IOConsole(scanner);
		Labirinto labirinto = Labirinto.newBuilder("labirinto.txt")
										.addStanzaIniziale("Atrio")
										.addAttrezzo("osso", 1)
										.addStrega("Varana"	, "Sono la strega,nel bosco oscuro la mia essenza risplende,  \n"
												+ "tra incanti e misteri il mio potere si estende.")
										.addStanzaBloccata("Corridoio", Direzione.valueOf("nord"), "lanterna")
										.addStanza("LabCampusOne")
										.addMago("Merlino", "Sono il mago, con bacchetta in mano e sguardo profondo, \n"
												+ "segreti antichi custodisco nel mio mondo.", new Attrezzo("bacchetta", 4))
										.addStanza("Aula N10")
										.addCane("Bau", "Sono il cane,fedele amico, nel buio mi muovo, \n"
												+ "vigile custode, il tuo cuore io provo.")
										.addAttrezzo("lanterna", 3)
										.addStanza("Aula N11")
										.addStanzaVincente("Biblioteca")
										.addAdiacenza("Atrio", "Aula N11", Direzione.valueOf("est"))
										.addAdiacenza("Atrio", "Aula N10", Direzione.valueOf("sud"))
										.addAdiacenza("Atrio", "LabCampusOne", Direzione.valueOf("ovest"))
										.addAdiacenza("Atrio", "Corridoio", Direzione.valueOf("nord"))
										.addAdiacenza("Corridoio", "Atrio", Direzione.valueOf("sud"))
										.addAdiacenza("Corridoio", "Biblioteca", Direzione.valueOf("nord"))
										.addAdiacenza("Aula N11", "LabCampusOne", Direzione.valueOf("est"))
										.addAdiacenza("Aula N11", "Atrio", Direzione.valueOf("ovest"))
										.addAdiacenza("Aula N10", "Atrio", Direzione.valueOf("nord"))
										.addAdiacenza("Aula N10", "Aula N11", Direzione.valueOf("est"))
										.addAdiacenza("Aula N10", "LabCampusOne", Direzione.valueOf("ovest"))
										.addAdiacenza("LabCampusOne", "Atrio", Direzione.valueOf("est"))
										.addAdiacenza("LabCampusOne", "Aula N11", Direzione.valueOf("ovest"))
										.getLabirinto();
		DiaDia gioco = new DiaDia(labirinto, io);
		gioco.gioca();
		scanner.close();
	}
}