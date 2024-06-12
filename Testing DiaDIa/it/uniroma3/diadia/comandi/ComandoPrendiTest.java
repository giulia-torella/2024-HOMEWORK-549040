package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPrendiTest {
	
	private Comando prendi;
	private Partita partita;
	private IO io;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		Scanner scanner = new Scanner(System.in);
		io = new IOConsole(scanner);
		partita = new Partita(Labirinto.newBuilder("labirinto2.txt").getLabirinto());
		prendi = new ComandoPrendi();
		prendi.setIO(io);
		attrezzo = new Attrezzo("torcia", 3);
	}

	@Test
	public void testAttrezzoPreso() {
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		prendi.setParametro("torcia");
		prendi.esegui(partita);
		assertEquals(partita.getGiocatore().getBorsa().getAttrezzo("torcia").getNome(), "torcia");
	}
	
	@Test
	public void testAttrezzoNonPreso() {
		prendi.setParametro("martello");
		prendi.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("torcia"));
	}

}
