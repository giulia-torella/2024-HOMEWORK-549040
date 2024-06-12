package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	
	Labirinto maze;
	Stanza biblioteca;
	Stanza atrio;
	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		maze = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		biblioteca = new Stanza("Biblioteca");
		atrio = new Stanza("Atrio");
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals(biblioteca.getNome(), maze.getStanzaVincente().getNome());
	}
	
	@Test
	public void testGetStanzaCorrente() {
		assertEquals(atrio.getNome(), maze.getStanzaCorrente().getNome());
	}


}
