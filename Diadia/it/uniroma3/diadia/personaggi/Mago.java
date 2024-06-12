package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio{
	
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
	"con una mia magica azione, troverai un nuovo oggetto " +
	"per il tuo borsone!";
	
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non " +
	"ho più nulla...";
	
	private Attrezzo attrezzo;
	
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		if(this.attrezzo!=null) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			return MESSAGGIO_DONO;
		}
		return MESSAGGIO_SCUSE;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome()))
			return "Non possiedi l'attrezzo che vuoi regalare.";
		Attrezzo attr = new Attrezzo(attrezzo.getNome(), attrezzo.getPeso()/2);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attr);
		return "Ho dimezzato il peso del tuo attrezzo..";
		
	}

}
