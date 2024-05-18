package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

import org.junit.Test;

public class ComandoVaiTest {
	
	private Partita p;
	private Comando vai;
	private Labirinto labirinto;
	private IO io;
	private Stanza N11;
	private Stanza atrio;
	
	@Before
	public void setUp() {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAdiacente("Atrio", "Aula N11", "ovest")
				.getLabirinto();
		io = new IOConsole();
		p = new Partita(labirinto);
		vai = new ComandoVai();
		vai.setIO(io);
		N11 = new Stanza("Aula N11");
		atrio = new Stanza("Atrio");
	}
	
	@Test
	public void testEsegui() {
		p.getLabirinto().setStanzaCorrente(atrio);
		atrio.impostaStanzaAdiacente("ovest", N11);
		vai.setParametro("ovest");
		vai.esegui(p);
		assertEquals(N11, p.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testNonEsegui() {
		p.getLabirinto().setStanzaCorrente(atrio);
		atrio.impostaStanzaAdiacente("ovest", N11);
		vai.setParametro("sud");
		vai.esegui(p);
		assertEquals(atrio, p.getLabirinto().getStanzaCorrente());
	}
	

}
