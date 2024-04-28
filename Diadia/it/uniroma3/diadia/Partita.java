package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private boolean finita; // true se la partita è finita, altrimenti false
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.finita = false; // all'inizio la partita non è finita, false
		this.giocatore = new Giocatore(); // i cfu posseduti all'inizio sono proprio i cfu iniziali
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	public boolean vinta() {
		return labirinto.getStanzaCorrente()== labirinto.getStanzaVincente(); // vero solo se stanza corrente è stanza vincente (ho vinto)
	}

	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0); // vero se finita=true oppure se vinta=true oppure se i cfu = 0
	}

	public void setFinita() { //setta finita = true
		this.finita = true;
	}
}
