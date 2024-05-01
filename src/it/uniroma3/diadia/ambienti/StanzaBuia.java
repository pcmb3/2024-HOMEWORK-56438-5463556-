package it.uniroma3.diadia.ambienti;


public class StanzaBuia extends Stanza{
	private String nomeAttrezzo;
	
	public StanzaBuia(String nome, String nomeAttrezzo) { //String nome si riferisce al nome della stanza buia ovvero il supertipo
		super(nome);
		this.nomeAttrezzo = nomeAttrezzo; //nomeAttrezzo è l'attrezzo che ci serve
	}
	
	@Override
	public String getDescrizione() {
		if(!(hasAttrezzo(nomeAttrezzo)))
			return "qui c'è un buio pesto";
		return super.getDescrizione();
	}
	
	

}
