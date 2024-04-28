package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Test;

public class StanzaBuiaTest {
	
	public Stanza setup() {
		Stanza s = new Stanza("Atrio");
		Attrezzo a = new Attrezzo("lanterna", 3);
		s.addAttrezzo(a);
		return s;
	}

	@Test
	public void testGetDescrizione() {
		Stanza stanzaVuota = new StanzaBuia(setup().getNome(), "osso");
		assertNotEquals(setup().getDescrizione(), stanzaVuota.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSuper() {
		Stanza stanzaVuota = new StanzaBuia(setup().getNome(), "lanterna");
		assertNotEquals(setup().getDescrizione(), stanzaVuota.getDescrizione());
	}

}
