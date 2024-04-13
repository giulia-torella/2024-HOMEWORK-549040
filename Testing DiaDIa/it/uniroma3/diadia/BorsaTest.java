package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	
	private Attrezzo attrezzo(String nome, int peso) {
		Attrezzo tool = new Attrezzo(nome, peso);
		return tool;
	}
	
	private Borsa borsa() {
		Borsa bag = new Borsa();
		bag.addAttrezzo(attrezzo("martello", 5));
		return bag;
	}
	
	private Borsa borsa(int pesoMax) {
		Borsa bag = new Borsa();
		bag.setPesoMax(pesoMax);
		return bag;
	}
	
	

	@Test
	public void testAddAttrezzo() {
		assertFalse(borsa(1).addAttrezzo(attrezzo("osso", 2)));
	}
	
	@Test
	public void testAddAttrezzo2() {
		assertTrue(borsa().addAttrezzo(attrezzo("osso", 2)));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		assertNotNull(borsa().removeAttrezzo("martello"));
	}
	
	@Test
	public void testIsEmpty() {
		assertFalse(borsa().addAttrezzo(null));
	}

}
