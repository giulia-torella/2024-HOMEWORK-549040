package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Before;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.*;

import org.junit.Test;

public class ComandoPosaTest {
	private Comando posa;
	private Partita partita;
	private Attrezzo attrezzo;
	private IO io;
	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		partita = new Partita(Labirinto.newBuilder("labirinto.txt").getLabirinto());
		Scanner scanner = new Scanner(System.in);
		io = new IOConsole(scanner);
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
