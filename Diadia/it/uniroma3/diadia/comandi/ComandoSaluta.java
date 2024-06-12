package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando{
	private final static String NOME = "saluta";

	@Override
	public void esegui(Partita partita) {
		if(partita.getLabirinto().getStanzaCorrente().getPersonaggio()!=null) {
			this.getIo().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getPersonaggio().saluta());
		}
		else
			this.getIo().mostraMessaggio("Non ci sono personaggi in questa stanza.");
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
