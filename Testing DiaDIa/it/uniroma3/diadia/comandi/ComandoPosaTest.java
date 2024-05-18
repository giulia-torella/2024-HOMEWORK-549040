package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.*;

import org.junit.Test;

public class ComandoPosaTest {
	private Labirinto labirinto;
	private Comando posa;
	private Partita partita;
	private Attrezzo attrezzo;
	private IO io;
	
	@Before
	public void setUp() {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.getLabirinto();
		partita = new Partita(labirinto);
		io = new IOConsole();
		posa = new ComandoPosa();
		posa.setIO(io);
		attrezzo = new Attrezzo("lanterna", 3);
	}
	
	@Test
	public void testAttrezzoNonPosato() {
		posa.setParametro("lanterna");
		posa.esegui(partita);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("lanterna"));
	}

	@Test
	public void testAttrezzoPosato() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		posa.setParametro("lanterna");
		posa.esegui(partita);
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("lanterna"));
	}
	
	

}
