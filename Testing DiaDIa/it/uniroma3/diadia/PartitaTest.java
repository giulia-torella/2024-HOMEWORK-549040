package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	private Labirinto labirinto;
	private Partita p;
	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		 labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		 p = new Partita(labirinto);
	}
	
	private Partita partita(int cfu, Stanza stanzaCorrente, Stanza stanzaVincente) {
		p.getGiocatore().setCfu(cfu);
		p.getLabirinto().setStanzaCorrente(stanzaCorrente);
		p.getLabirinto().setStanzaVincente(stanzaVincente);
		return p;
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
