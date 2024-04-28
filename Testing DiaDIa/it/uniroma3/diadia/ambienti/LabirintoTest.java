package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;


import org.junit.Test;

public class LabirintoTest {
	
	private Labirinto labirinto() {
		Labirinto maze = new Labirinto();
		return maze;
	}

	@Test
	public void testGetStanzaVincente() {
		assertNotNull(labirinto().getStanzaVincente());
	}
	
	@Test
	public void testGetStanzaCorrente() {
		assertNotNull(labirinto().getStanzaVincente());
	}


}
