package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class AbstractPersonaggioTest {
	
	private Partita p;
	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		Labirinto l = Labirinto.newBuilder("labirinto3.txt").getLabirinto();
		p = new Partita(l);
		p.getLabirinto().setStanzaCorrente(new Stanza("Atrio"));
		Stanza biblioteca = new Stanza("Biblioteca");
		biblioteca.addAttrezzo(new Attrezzo("osso", 2));
		Stanza N10 = new Stanza("N10");
		p.getLabirinto().getStanzaCorrente().impostaStanzaAdiacente(Direzione.valueOf("nord"), biblioteca);
		p.getLabirinto().getStanzaCorrente().impostaStanzaAdiacente(Direzione.valueOf("sud"), N10);
	}
	
	@Test
	public void agisciStregaPositivoTest() {
		Strega s = new Strega("Strega", "Sono la strega.");
		s.saluta();
		s.agisci(p);
		assertEquals(p.getLabirinto().getStanzaCorrente().getNome(), "Biblioteca");
	}
	
	@Test
	public void agisciStregaNegativoTest() {
		Strega s = new Strega("Strega", "Sono la strega.");
		s.agisci(p);
		assertEquals(p.getLabirinto().getStanzaCorrente().getNome(), "N10");
	}
	
	@Test
	public void caneMordiTest() {
		Cane c = new Cane("Cane", "BAU BAU");
		c.agisci(p);
		assertEquals(p.getGiocatore().getCfu(), 20);
		c.saluta();
		c.agisci(p);
		assertEquals(p.getGiocatore().getCfu(), 19);
	}
	
	@Test
	public void magoPositivoTest() {
		Attrezzo osso = new Attrezzo("Osso", 1);
		Mago m = new Mago("Mago", "Sono il mago.", osso);
		m.agisci(p);
		assertNotNull(p.getLabirinto().getStanzaCorrente().getAttrezzi());
		assertTrue(p.getLabirinto().getStanzaCorrente().getAttrezzi().contains(osso));
	}
	
	@Test
	public void magoNegativoTest() {
		Attrezzo osso = new Attrezzo("Osso", 1);
		Mago m = new Mago("Mago", "Sono il mago.", null);
		m.agisci(p);
		assertEquals(p.getLabirinto().getStanzaCorrente().getAttrezzi().size(), 0);
		assertFalse(p.getLabirinto().getStanzaCorrente().getAttrezzi().contains(osso));
	}

}
