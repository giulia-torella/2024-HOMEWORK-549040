package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	private Direzione direzioneBloccata;
	private String attrezzoSbloccante;
	
	public StanzaBloccata(String nome, Direzione direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.attrezzoSbloccante = attrezzoSbloccante;
		this.direzioneBloccata = direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione dir) {
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
    	risultato.append(this.getDirezioni().toString());
    	risultato.append("\nLa direzione bloccata è " + direzioneBloccata + " e "
    			+ "può essere sbloccata solo dall'attrezzo " + attrezzoSbloccante);
    	risultato.append("\nAttrezzi nella stanza: ");
    	risultato.append(this.getAttrezzi().toString());
    	return risultato.toString(); 
    }

}
