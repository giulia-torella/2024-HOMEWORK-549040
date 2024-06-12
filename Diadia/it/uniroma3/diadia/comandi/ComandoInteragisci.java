package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando {
	
	private static final String NOME = "interagisci";
	
	private static final String MESSAGGIO_VUOTO =	"Non c'è nessuno qui..";

	private String messaggio;
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			this.messaggio = personaggio.agisci(partita);
			this.getIo().mostraMessaggio(this.messaggio);
		} else this.getIo().mostraMessaggio(MESSAGGIO_VUOTO);
	}

	public String getMessaggio() {
		return this.messaggio;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
}
