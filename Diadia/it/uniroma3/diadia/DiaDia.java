package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comandi.*;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 * @version base
 */

public class DiaDia {
	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	private Partita partita;
	private IO io;

	public DiaDia(IO console, Labirinto labirinto) {
		this.io = console;
		this.partita = new Partita(labirinto);
	}
	
	public static String mostraMessaggioBenvenuto() {
		return MESSAGGIO_BENVENUTO;
	}

	public void gioca() {
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			istruzione = io.leggiRiga();
		}  
        while (!processaIstruzione(istruzione));
	}   
	
	private boolean processaIstruzione(String istruzione) { // processa un'istruzione, true se è processata, false altrimenti
		Comando comandoDaEseguire; // la stringa istruzione viene passata come parametro al comando da eseguire
		
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(this.io);
		
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		
		if(this.partita.vinta()) io.mostraMessaggio("Hai vinto!");
		if(this.partita.getGiocatore().getCfu()==0) io.mostraMessaggio("Hai esaurito i tuoi CFU.");
		return this.partita.isFinita();
	}


	public static void main(String[] argc) {
		IO console = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
										.addStanzaIniziale("Atrio")
										.addAttrezzo("osso", 1)
										.addStanzaVincente("Biblioteca")
										.addStanzaMagica("Aula N11")
										.addAttrezzo("piedediporco", 2)
										.addStanzaBloccata("Aula N10", "piedediporco", "est")
										.addAttrezzo("lanterna", 3)
										.addStanzaBuia("Laboratorio Campus", "lanterna")
										.addAdiacente("Atrio", "Biblioteca", "nord")
										.addAdiacente("Atrio", "Aula N11", "est")
										.addAdiacente("Atrio", "Aula N10", "sud")
										.addAdiacente("Atrio", "Laboratorio Campus", "ovest")
										.addAdiacente("Aula N11", "Laboratorio Campus", "est")
										.addAdiacente("Aula N11", "Atrio", "ovest")
										.addAdiacente("Aula N10", "Atrio", "nord")
										.addAdiacente("Aula N10", "Aula N11", "est")
										.addAdiacente("Aula N10", "Laboratorio Campus", "ovest")
										.addAdiacente("Laboratorio Campus", "Atrio", "est")
										.addAdiacente("Laboratorio Campus", "Aula N11", "ovest")
										.addAdiacente("Biblioteca", "Atrio", "sud")
										.getLabirinto();
		DiaDia gioco = new DiaDia(console, labirinto);
		gioco.gioca();
	}
}