package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Simulatore;

public class ComandoFineTest {

	List<String> daLeggere;

	@Before
	public void setUp(){
		daLeggere = new ArrayList<>();
	}

	@Test
	public void testPartitaFine() {
		daLeggere.add("fine");

		IOSimulator io = Simulatore.simulazionePartita3(daLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.mostraMessaggioBenvenuto(), io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.mostraMessaggioFinale(), io.nextMessaggio());

	}

}