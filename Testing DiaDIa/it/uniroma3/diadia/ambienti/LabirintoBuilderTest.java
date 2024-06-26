package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

import org.junit.Before;
import org.junit.Test;

public class LabirintoBuilderTest {
	
	Labirinto.LabirintoBuilder maze;
	Stanza room;
	
	@Before
	public void setUp() throws Exception {
		maze = new LabirintoBuilder("labirinto1.txt");
	}
	
	@Test
	public void testGetLabirinto() {
		assertNotNull(maze.getLabirinto());
		assertEquals(Labirinto.class, maze.getLabirinto().getClass());
	}
	
	@Test
	public void testAddStanzaIniziale() {
		maze.addStanzaIniziale(room.getNome());
		Stanza expected = new Stanza("Atrio");
		assertEquals(expected.getNome(), maze.getNome2stanza().get("Atrio").getNome());
	}
	
	@Test
	public void testAddStanzaVincente() {
		maze.addStanzaVincente("Biblioteca");
		Stanza expected = new Stanza("Biblioteca");
		assertEquals(expected.getNome(), maze.getNome2stanza().get("Biblioteca").getNome());
	}
	
	@Test
	public void testAddAttrezzo() {
		maze.addStanzaIniziale("Atrio");
		maze.addAttrezzo("torcia", 3);
		assertTrue(maze.getNome2stanza().get("Atrio").hasAttrezzo("torcia"));
	} 

}
