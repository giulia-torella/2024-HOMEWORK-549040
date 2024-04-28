package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	
	private String direzioneBloccata;
	private String attrezzoSbloccante;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.attrezzoSbloccante = attrezzoSbloccante;
		this.direzioneBloccata = direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(!this.hasAttrezzo(attrezzoSbloccante) && direzioneBloccata.equals(dir))
			return this;
		return super.getStanzaAdiacente(dir);
	}

	@Override
    public String getDescrizione() { // ritorna la descrizione in stringa della stanza
        return this.toString();
	}
	
	@Override
	public String toString() { 
    	StringBuilder risultato = new StringBuilder(); 
    	risultato.append("Ti trovi in: " + super.getNome()); 
    	risultato.append("\nSi tratta di una stanza bloccata..");
    	risultato.append("\nLe direzioni disponibili sono: ");
    	for (String direzione : this.getDirezioni())
    		if (direzione!=null)
    			risultato.append(" " + direzione);
    	risultato.append("\nLa direzione bloccata è " + direzioneBloccata + " e "
    			+ "può essere sbloccata solo dall'attrezzo " + attrezzoSbloccante);
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (Attrezzo attrezzo : this.getAttrezzi()) {
    		if(attrezzo!=null)
    		    risultato.append(attrezzo.toString()+" "); 
    	}
    	return risultato.toString(); 
    }

}
