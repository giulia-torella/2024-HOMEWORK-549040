package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	
	Labirinto maze;
	Stanza biblioteca;
	Stanza atrio;
	
	@Before
	public void labirinto() {
		maze = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addStanzaVincente("Biblioteca")
				.addAdiacente("Atrio", "Laboratorio Campus", "sud")
				.addAdiacente("Atrio", "Biblioteca", "nord")
				.getLabirinto();
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
