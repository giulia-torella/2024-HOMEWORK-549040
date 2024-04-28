package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

import org.junit.Test;

public class ComandoVaiTest {
	
	private Partita p;
	private ComandoVai comandoVai;
	
	private Partita setting(String nomeCorrente, String nomeAdiacente) {
		p = new Partita();
		comandoVai = new ComandoVai();
		comandoVai.setDirezione("nord");
		p.getLabirinto().setStanzaCorrente(new Stanza(nomeCorrente));
		p.getLabirinto().getStanzaCorrente().impostaStanzaAdiacente(comandoVai.getDirezione(), new Stanza(nomeAdiacente));
		comandoVai.esegui(p);
		return p;
	}
	
	private Partita setting(String nomeCorrente, String nomeAdiacente, String direzione) {
		p = new Partita();
		comandoVai = new ComandoVai();
		comandoVai.setDirezione("sud");
		p.getLabirinto().setStanzaCorrente(new Stanza(nomeCorrente));
		p.getLabirinto().getStanzaCorrente().impostaStanzaAdiacente(direzione, new Stanza(nomeAdiacente));
		comandoVai.esegui(p);
		return p;
	}

	/* Controlla che la stanza corrente da atrio diventi poi biblioteca */
	@Test
	public void testEsegui() {
		assertEquals(setting("Atrio", "Biblioteca").getLabirinto().getStanzaCorrente().getNome(), new Stanza("Biblioteca").getNome());
	}
	
	/* Controlla che al passaggio da atrio a biblioteca perdo un CFU */
	@Test
	public void testEseguiCFU() {
		assertEquals(setting("Atrio", "Biblioteca").getGiocatore().getCfu(), 19);
	}
	
	@Test
	public void testNonEsegui2() {
		assertNotEquals(setting("Atrio", "Biblioteca", "ovest").getLabirinto().getStanzaCorrente().getNome(), new Stanza("Biblioteca").getNome());
	}
	

}
