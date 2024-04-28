package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

public class ComandoVai implements Comando{
	
	private IO io = new IOConsole();
	private String direzione;
	
	@Override
	public void esegui(Partita partita) {
		Stanza prossimaStanza = null;
		if (this.direzione == null) {
			io.mostraMessaggio("Non hai specificato alcuna direzione. Puoi scegliere tra:");
			for(String direzione: partita.getLabirinto().getStanzaCorrente().getDirezioni()) {
				if(direzione!=null) io.mostraMessaggio(direzione);
			}
			return;
		}
		prossimaStanza = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null)

		{
			io.mostraMessaggio("Direzione inesistente");;
			return;
		}
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio("Ora ti trovi in "+ partita.getLabirinto().getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
	}
	
	public void setDirezione(String direzione) {
		this.direzione = direzione;
	}
	
	public String getDirezione() {
		return this.direzione;
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return null;
	}

}
