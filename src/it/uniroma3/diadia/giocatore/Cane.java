package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{

	/*Morde e così fanendo diminuisce i CFU del giocatore*/

	private static final String MESSAGGIO_MORDE = "Bau bau, attento umano, " +
			"ora che ti ho morso piano,\n" +
			"un CFU ti ho tolto, " +
			"questo avviso ti ho rivolto.\n" +
			"Bau bau, fai attenzione, " +
			"prosegui con precauzione!";

	private static final String MESSAGGIO_NON_MORDE = "Bau bau, che gioia mi hai dato, "
			+ "il mio cibo preferito mi hai portato!\n" 
			+ "Sei davvero gentile e cortese, "
			+  "ti lascio in pace, prosegui senza offese.";
	
	private static final String MESSAGGIO_CIBO_NON_PREFERITO = "Bau bau, sono ancora affamato,\n" +
						            "il mio cibo preferito non hai portato.\n" +
						            "Un CFU ti tolgo senza esitazione,\n" +
						            "la prossima volta, scegli con precisione.\n" +
						            "Bau bau, fai attenzione, d'ora in poi prosegui con precauzione!";

	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO_MORDE;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg;
		if(attrezzo.getNome().equals("osso")) {
			msg =MESSAGGIO_NON_MORDE;
		}
		else {
			msg=MESSAGGIO_CIBO_NON_PREFERITO;
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
		return msg;
	}
}
