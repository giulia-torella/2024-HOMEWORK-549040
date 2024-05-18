package it.uniroma3.diadia;

import java.util.List;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;


public class Simulatore {
	
	public static IOSimulator simulazionePartita1(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto l = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio") 
				.addStanzaVincente("Atrio") 
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, l);
		gioco.gioca();
		return io;
	}
	public static IOSimulator simulazionePartita2(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 1)
				.addStanzaVincente("Biblioteca")
				.addAdiacente("Atrio", "Biblioteca", "nord")
				.addAdiacente("Biblioteca", "Atrio", "sud")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}

	public static IOSimulator simulazionePartita4(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 1)
				.addStanzaVincente("Biblioteca")
				.addAdiacente("Atrio", "Biblioteca", "nord")
				.addAdiacente("Biblioteca", "Atrio", "sud")
				.addStanza("Aula N11")
				.addAdiacente("Aula N11", "Atrio", "ovest")
				.addAdiacente("Atrio", "Aula N11", "est")
				.addStanza("Laboratorio")
				.addAdiacente("Laboratorio", "Atrio", "sud")
				.addAdiacente("Atrio", "Laboratorio", "nord")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}
	
	public static IOSimulator simulazionePartita3(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto l = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addStanza("Aula N10")
				.addAttrezzo("osso",1) 
				.addStanzaVincente("Aula N11")
				.addAdiacente("AulaN10", "Atrio", "nord")
				.addAdiacente("Aula N11", "Aula N10", "est")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, l);
		gioco.gioca();
		return io;
	}
}
