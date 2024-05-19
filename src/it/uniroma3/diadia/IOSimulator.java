package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {
    private List<String> messaggiMostrati;
    private List<String> righeDaLeggere;
    private int indiceRigheLette;

    public IOSimulator(List<String> righeDaLeggere) {
        this.messaggiMostrati = new ArrayList<>();
        this.righeDaLeggere = righeDaLeggere;
        this.indiceRigheLette = 0;
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        this.messaggiMostrati.add(messaggio);
    }

    @Override
    public String leggiRiga() {
        if (indiceRigheLette < righeDaLeggere.size()) {
            return righeDaLeggere.get(indiceRigheLette++);
        } else {
            return null; 
        }
    }
    
    public List<String> getMostraMessaggio(){
    	return this.messaggiMostrati;
    }

}
