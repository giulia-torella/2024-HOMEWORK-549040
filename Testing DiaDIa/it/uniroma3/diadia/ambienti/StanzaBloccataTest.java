package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Test;

public class StanzaBloccataTest {
	
	public Stanza setupNonBloccata() {
		Stanza stanzaNonBloccata = new StanzaBloccata("Atrio", Direzione.valueOf("est"), "piedediporco");
		Attrezzo piedediporco = new Attrezzo("piedediporco", 2);
		stanzaNonBloccata.addAttrezzo(piedediporco);
		Stanza s = new Stanza("Aula N11");
		stanzaNonBloccata.impostaStanzaAdiacente(Direzione.valueOf("est"), s);
		return stanzaNonBloccata;
	}
	
	public Stanza setupBloccata() {
		Stanza stanzaNonBloccata = new StanzaBloccata("Atrio", Direzione.valueOf("est"), "piedediporco");
		Stanza s = new Stanza("Aula N11");
		stanzaNonBloccata.impostaStanzaAdiacente(Direzione.valueOf("est"), s);
		return stanzaNonBloccata;
	}

	@Test
	public void testStanzaNonBloccata() {
		assertNotEquals(setupNonBloccata().getNome(), setupNonBloccata().getStanzaAdiacente(Direzione.valueOf("est")).getNome());
	}
	
	@Test
	public void testStanzaBloccata() {
		assertEquals(setupBloccata().getNome(), setupBloccata().getStanzaAdiacente(Direzione.valueOf("est")).getNome());
	}

}
