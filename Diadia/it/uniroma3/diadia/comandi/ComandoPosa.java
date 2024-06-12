package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.Partita;

public class ComandoPosa extends AbstractComando{
	
	private final static String NOME = "posa";
	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(partita.getLabirinto().getStanzaCorrente().getNumeroAttrezziPossibili()>0) {
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			if(nomeAttrezzo != null && partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo)) 
				this.getIo().mostraMessaggio("Ho aggiunto " + nomeAttrezzo + " alla stanza " + 
			     partita.getLabirinto().getStanzaCorrente().getNome());
			else this.getIo().mostraMessaggio("Non è stato aggiunto alcun attrezzo alla stanza " 
			     + partita.getLabirinto().getStanzaCorrente().getNome());
		}
		if(attrezzo != null && partita.getGiocatore().getBorsa().getPeso()+attrezzo.getPeso()>partita.getGiocatore().getBorsa().getPesoMax()) 
			this.getIo().mostraMessaggio("Non ho aggiunto " + nomeAttrezzo + " alla stanza " 
		+ partita.getLabirinto().getStanzaCorrente().getNome() + " perchè la stanza è piena");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
