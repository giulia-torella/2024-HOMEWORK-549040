package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;


import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

import org.junit.Test;

public class ComandoPosaTest {
	
	private ComandoPosa posa = new ComandoPosa();
	private Partita p = new Partita();
	
	private void setting() {
		posa.setIO(new IOConsole());
		posa.setParametro("osso");
	}
	
	@Test
	public void testAttrezzoNonPosato() {
		posa = new ComandoPosa();
		setting();
		posa.setParametro("lanterna");
		posa.esegui(p);
		assertFalse(p.getLabirinto().getStanzaCorrente().hasAttrezzo("lanterna"));
	}

	@Test
	public void testAttrezzoPosato() {
		setting();
		p.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("osso", 1));
		posa.esegui(p);
		assertTrue(p.getLabirinto().getStanzaCorrente().hasAttrezzo("osso"));
	}
	
	

}
