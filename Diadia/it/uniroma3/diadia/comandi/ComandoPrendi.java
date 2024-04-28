package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

public class ComandoPrendi implements Comando {

	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "prendi";

	
	@Override
	public void esegui(Partita partita) {
		boolean aggiunto = false;
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(partita.getGiocatore().getBorsa().getPesoRimanente(a)) {
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			for(Attrezzo attrezzo: partita.getLabirinto().getStanzaCorrente().getAttrezzi()) {
				if (attrezzo != null)
					if (attrezzo.getNome().equals(nomeAttrezzo))
						aggiunto = true;
			}
			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
		} 
		else {
			if(nomeAttrezzo == null) io.mostraMessaggio("Non hai specificato alcun attrezzo da prendere.");
			else if(!aggiunto && nomeAttrezzo!=null) io.mostraMessaggio("L'attrezzo che hai digitato non esiste nella stanza.");
			else io.mostraMessaggio("Attrezzo troppo pesante per entrare nella borsa!");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo  = parametro;

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
