package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private String direzBloccata;
	private String nomeAttSblocca;
	
	public StanzaBloccata(String nome, String direzBloccata, String nomeAttSblocca) {
		super(nome);
		this.direzBloccata = direzBloccata;
		this.nomeAttSblocca = nomeAttSblocca;
	}
	
	public Stanza getStanzaAdiacente(String dir){
		if(!(hasAttrezzo(nomeAttSblocca)) && dir.equals(direzBloccata)) 
			return (Stanza) this;
		return super.getStanzaAdiacente(dir);
	}
	
	@Override
	public String getDescrizione() {
		if(!(hasAttrezzo(nomeAttSblocca)))
			return "Questa direzione è bloccata! Per sbloccarla devi posare l'attrezzo" + this.nomeAttSblocca + "nella stanza";
		return super.getDescrizione();
	}
}
