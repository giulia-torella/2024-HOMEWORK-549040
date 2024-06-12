package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando{
	
	private final static String NOME = "guarda";

	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		this.getIo().mostraMessaggio("Possiedi: "+partita.getGiocatore().getCfu()+ "CFU");
		this.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		if(partita.getLabirinto().getStanzaCorrente().getPersonaggio()!=null) {
			this.getIo().mostraMessaggio("Personaggi: " + partita.getLabirinto().getStanzaCorrente().getPersonaggio().getNome());
		}
		
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
