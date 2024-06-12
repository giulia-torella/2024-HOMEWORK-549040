package it.uniroma3.diadia;

import java.util.List;


import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Simulatore {
	public static IOSimulator Gioco1(List<String> comandiDaLeggere) throws Exception {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}

	public static IOSimulator Gioco2(List<String> comandiDaLeggere) throws Exception {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto 		 labirinto = Labirinto.newBuilder("labirinto4.txt").getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}

	public static Attrezzo creaAttrezzoEAggiugniAStanza(Stanza stanzaDaRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}

}
