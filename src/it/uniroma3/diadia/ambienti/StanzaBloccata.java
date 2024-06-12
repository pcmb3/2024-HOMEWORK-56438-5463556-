package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	private Direzione direzioneBloccata;
	private String passepartout;
	
	public StanzaBloccata(String nome, Direzione direzione, String passepartout) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.passepartout = passepartout;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
        if(direzione.equals(this.direzioneBloccata) && !hasAttrezzo(this.passepartout))
         return (Stanza) this;
       return super.getStanzaAdiacente(direzione); 
	}
	
	@Override
	 public String getDescrizione() {
		if(!hasAttrezzo(this.passepartout))
			return "Questa direzione è bloccata! Per sbloccarla devi posare l'attrezzo " + this.passepartout + " nella stanza";
		return super.getDescrizione();
    }
}
