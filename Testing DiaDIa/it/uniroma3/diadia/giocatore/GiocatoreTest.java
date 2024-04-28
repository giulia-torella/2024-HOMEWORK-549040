package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiocatoreTest {
	
	private Giocatore giocatore() {
		Giocatore player = new Giocatore();
		return player;
	}

	@Test
	public void testGetBorsa() {
		assertNotNull(giocatore().getBorsa());
	}
	
	@Test
	public void testGetCfu() {
		assertEquals(giocatore().getCfu(), 20);
	}

}
