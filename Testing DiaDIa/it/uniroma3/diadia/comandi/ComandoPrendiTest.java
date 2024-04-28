package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;


import org.junit.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;;


public class ComandoPrendiTest {
	
	private Partita p;
	private ComandoPrendi prendi = new ComandoPrendi();
	
	private void setting() {
		p = new Partita();
		prendi.setParametro("osso");
	}

	@Test
	public void testAttrezzoPreso() {
		setting();
		p.getLabirinto().getStanzaCorrente().addAttrezzo(new Attrezzo("osso", 1));
		prendi.esegui(p);
		assertEquals(p.getGiocatore().getBorsa().getAttrezzo("osso").getNome(), prendi.getParametro());
	}
	
	public void testAttrezzoNonPreso() {
		setting();
		p.getGiocatore().getBorsa().setPesoMax(0);
		prendi.esegui(p);
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo(prendi.getParametro()));
	}

}
