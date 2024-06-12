package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonicaTest {

	Scanner scanner = new Scanner(System.in);
	IOConsole console = new IOConsole(scanner);
	private FabbricaDiComandiFisarmonica comando = new FabbricaDiComandiFisarmonica(console);
	
	@Test
	public void testCostruisciComandoGuarda() {
		assertEquals(comando.costruisciComando("guarda").getNome(), "guarda");
	}
	
	@Test
	public void testCostruisciComandoVai() {
		assertNotNull(comando.costruisciComando("vai"));
	}
	
	@Test
	public void testCostruisciComandoVai2() {
		assertNotNull(comando.costruisciComando("vai nord").getParametro());
	}
	
	@Test
	public void testCostruisciComandoPosa() {
		assertNotNull(comando.costruisciComando("posa"));
	}
	
	@Test
	public void testCostruisciComandoPosa2() {
		assertNotNull(comando.costruisciComando("posa osso").getParametro());
	}
	
	@Test
	public void testCostruisciComandoPrendi() {
		assertNotNull(comando.costruisciComando("prendi"));
	}
	
	@Test
	public void testCostruisciComandoPrendi2() {
		assertNotNull(comando.costruisciComando("prendi lanterna").getParametro());
	}
	
	@Test
	public void testCostruisciComandoNonValido() {
		assertNotNull(comando.costruisciComando(""));
	}
	
	@Test
	public void testCostruisciComandoAiuto() {
		assertNotNull(comando.costruisciComando("aiuto"));
	}

}
