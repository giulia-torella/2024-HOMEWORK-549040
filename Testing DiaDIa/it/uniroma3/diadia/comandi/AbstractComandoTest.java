package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class AbstractComandoTest {
	private AbstractComando vai;
	private AbstractComando posa;
	private AbstractComando prendi;
	private Partita p;
	private IO io;
	
	@Before
	public void setUp() throws Exception {
		vai = new ComandoVai();
		posa = new ComandoPosa();
		prendi = new ComandoPrendi();
		p = new Partita(Labirinto.newBuilder("labirinto1.txt").getLabirinto());
		p.getLabirinto().setStanzaCorrente(new Stanza("Atrio"));
		p.getLabirinto().getStanzaCorrente().impostaStanzaAdiacente(Direzione.valueOf("nord"), new Stanza("Biblioteca"));
		Scanner scanner = new Scanner(System.in);
		io = new IOConsole(scanner);
	}

	@Test
	public void testVai() {
		vai.setParametro("sud");
		vai.esegui(p);
		assertEquals("Atrio", p.getLabirinto().getStanzaCorrente().getNome());
		vai.setParametro("nord");
		vai.esegui(p);
		assertEquals("Biblioteca", p.getLabirinto().getStanzaCorrente().getNome());
		assertEquals(vai.getParametro(), "nord");
	}
	
	@Test
	public void testPrendi() {
		prendi.setIO(io);
		Attrezzo osso = new Attrezzo("osso", 1);
		prendi.esegui(p);
		assertNull(p.getGiocatore().getBorsa().getAttrezzo("osso"));
		prendi.setParametro("osso");
		p.getLabirinto().getStanzaCorrente().addAttrezzo(osso);
		prendi.esegui(p);
		assertEquals(p.getGiocatore().getBorsa().getAttrezzo("osso").getNome(), osso.getNome());
	}
	
	@Test
	public void testPosa() {
		posa.setIO(io);
		Attrezzo osso = new Attrezzo("osso", 1);
		posa.setParametro("osso");
		posa.esegui(p);
		assertEquals(p.getLabirinto().getStanzaCorrente().getAttrezzi().size(), 0);
		p.getGiocatore().getBorsa().addAttrezzo(osso);
		posa.esegui(p);
		assertEquals(p.getLabirinto().getStanzaCorrente().getAttrezzo("osso").getNome(), osso.getNome());
	}
	

}
