package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	
	private static final String MESSAGGIO_POSITIVO = "Grazie per avermi salutato! " +
	"Ti sposterò nella stanza adiacente con più attrezzi!";
	
	private static final String MESSAGGIO_NEGATIVO = "Come osi! " +
			"Per punirti ti sposterò nella stanza adiacente con meno attrezzi!";
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		List<Stanza> s = null;
		if(partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti().size()>0) {
			s = partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();
		}
		if(s==null) return "Non ci sono stanze adiacenti disponibili.";
		if(super.haSalutato()) {
			int max = s.get(0).getNumeroAttrezziCorrente();
			Direzione direzione = null;
			for(Direzione d: partita.getLabirinto().getStanzaCorrente().getDirezioni()) {
				if(partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(d).getNumeroAttrezziCorrente()>=max) {
					max = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(d).getNumeroAttrezziCorrente();
					direzione = d;
				}
			}
			partita.getLabirinto().setStanzaCorrente(partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione));
			return MESSAGGIO_POSITIVO;
		}
		else {
			int min = s.get(0).getNumeroAttrezziCorrente();
			Direzione direzione = null;
			for(Direzione d: partita.getLabirinto().getStanzaCorrente().getDirezioni()) {
				if(partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(d).getNumeroAttrezziCorrente()<=min) {
					min = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(d).getNumeroAttrezziCorrente();
					direzione = d;
				}
			}
			partita.getLabirinto().setStanzaCorrente(partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione));
			return MESSAGGIO_NEGATIVO;
		}
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome()))
			return "Non possiedi l'attrezzo che vuoi regalare.";
		return "HA HA HA HA!";
	}

}
