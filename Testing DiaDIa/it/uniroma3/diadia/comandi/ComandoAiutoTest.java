package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Simulatore;

public class ComandoAiutoTest {

	List<String> righeDaLeggere;

	@Before
	public void setUp(){
		righeDaLeggere = new ArrayList<>();
	}

	@Test
	public void testPartitaAiuto() {
		righeDaLeggere.add("aiuto");
		righeDaLeggere.add("fine");
		IOSimulator io = Simulatore.simulazionePartita2(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.mostraMessaggioBenvenuto(), io.nextMessaggio());
		for(int i=0; i < ComandoAiuto.ELENCO_COMANDI.length; i++) {
			assertTrue(io.hasNextMessaggio());
			assertEquals(ComandoAiuto.ELENCO_COMANDI[i]+" ", io.nextMessaggio());
		}
		assertTrue(io.hasNextMessaggio());
		io.nextMessaggio();
		assertEquals(ComandoFine.mostraMessaggioFinale(), io.nextMessaggio());
	}
}