package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	private Partita partita(int cfu, Stanza stanzaCorrente, Stanza stanzaVincente) {
		Partita game = new Partita();
		game.getGiocatore().setCfu(cfu);
		game.getLabirinto().setStanzaCorrente(stanzaCorrente);
		game.getLabirinto().setStanzaVincente(stanzaVincente);
		return game;
	}

	@Test
	public void testvinta() {
		assertFalse(partita(0, new Stanza("Atrio"), new Stanza("Biblioteca")).vinta());
	}
	
	@Test
	public void testIsFinita() {
		assertTrue(partita(0, new Stanza("Atrio"), new Stanza("Aula N11")).isFinita());
	}

}
