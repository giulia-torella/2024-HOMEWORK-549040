package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	
	private static final String MESSAGGIO_MORSO = "GRR BAU BAU!";
	private static final String CIBO_PREFERITO = "osso";
	
	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		this.mordi(partita);
		return MESSAGGIO_MORSO;
	}
	
	public void mordi(Partita partita) {
		if(this.haSalutato()) 
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		else return;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder string = new StringBuilder();
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome()))
			return "Non possiedi l'attrezzo che vuoi regalare.";
		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(new Attrezzo("Torcia", 5));
			string.append("Hai regalato al cane il suo cibo preferito!");
		}
		else {
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			string.append("Il cane ti ha morso!");
		}
		return string.toString();
	}

}
