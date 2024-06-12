package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{

	/*Se interagiamo con lei ci trasferisce in una stanza adiacente;
	 * se non l'abbiamo salutata in una stanza con meno attrezzi
	 * se l'abbiamo salutata in una stanza con più attrezzi*/
	
	private static final String MESSAGGIO_SALUTATA = "Sei davvero molto cordiale, " +
											        "il tuo saluto è speciale,\n" +
											        "per premiarti ti manderò, " +
											        "dove più attrezzi troverò, \n" +
											        "e così più chance avrai, " +
											        "di vincere se li userai!";
	private static final String MESSAGGIO_NON_SALUTATA = "Sei un vero maleducato, \n" +
														"ora ti trasferirò, preparati, sei avvisato, \n" +
														"in un luogo sperduto e abbandonato "+
														"dove pochi attrezzi ho posato";	
	
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}
	
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		List<Stanza> stanzeAdiacenti = partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();

		Stanza maxAttrezzi = stanzeAdiacenti.get(0);
		Stanza minAttrezzi = stanzeAdiacenti.get(0);

		for(Stanza s : stanzeAdiacenti) {
			if(s != null) {
				if(s.getNumeroAttrezzi() > maxAttrezzi.getNumeroAttrezzi())
					maxAttrezzi = s;
				if(s.getNumeroAttrezzi() < minAttrezzi.getNumeroAttrezzi())
					minAttrezzi = s;
			}
		}

		if(this.haSalutato()) {
			partita.getLabirinto().setStanzaCorrente(maxAttrezzi);
			msg = MESSAGGIO_SALUTATA;
		} else {
			partita.getLabirinto().setStanzaCorrente(minAttrezzi);
			msg = MESSAGGIO_NON_SALUTATA;
		}

		return msg;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg = "AHAHAHAAHAHAHAHA"; 
		if(attrezzo!=null) {
			return msg;
		}
		return "Non mi hai regalato nulla.";
		}


	
}
