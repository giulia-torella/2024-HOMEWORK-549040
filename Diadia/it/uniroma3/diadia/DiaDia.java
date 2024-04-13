package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Stanza;

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
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole console = new IOConsole();

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		console.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			istruzione = console.leggiRiga();
		}  
        while (!processaIstruzione(istruzione) );
	}   
	
	private boolean processaIstruzione(String istruzione) { // processa un'istruzione, true se è processata, false altrimenti
		Comando comandoDaEseguire = new Comando(istruzione); // la stringa istruzione viene passata come parametro al comando da eseguire

		if (comandoDaEseguire.getNome().equals("fine")) { // se stringa = fine
			this.fine(); // esegui comando fine
			return true; // istruzione processata
		} else if (comandoDaEseguire.getNome().equals("vai"))  // se stringa = vai
			this.vai(comandoDaEseguire.getParametro()); // esegui vai e chiedi il parametro direzione
		else if (comandoDaEseguire.getNome().equals("aiuto")) // se stringa = aiuto
			this.aiuto(); // esegui il comando aiuto
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			console.mostraMessaggio("Comando sconosciuto"); // se il comando non è uguale a nulla, è sconosciuto
		if (this.partita.vinta()) { // se la partita è vinta
			console.mostraMessaggio("Hai vinto!"); // stampa vittoria
			return true; // comando eseguito
		} else
			return false; // altrimenti nessun comando è stato processato
	}   

	private void aiuto() { // ritorna l'insieme dei comandi utilizzabili
		console.mostraMessaggio("I comandi utilizzabili sono:");
		for(int i=0; i< elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");
		console.mostraMessaggio("");
	}
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) { // comando vai a cui è specificata una direzione
		
		Stanza prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione); // la prossima stanza diventa l'adiacente della corrente rispetto alla direzione
		boolean exists = false;
		for (int i=0; i<partita.getLabirinto().getStanzaCorrente().getDirezioni().length; i++) {
			if(direzione != null)
			    if(direzione.equals(partita.getLabirinto().getStanzaCorrente().getDirezioni()[i]))
				    exists = true;
		}
		if(!exists && (direzione != null)) 
			console.mostraMessaggio("Questa direzione non esiste tra le proposte.");
		
		else if (direzione == null) // se risulta null
			console.mostraMessaggio("Direzione inesistente"); // non hai scritto alcuna direzione
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza); // setto come stanza corrente la stanza successiva
			int cfu = this.partita.getGiocatore().getCfu(); // ottendo i cfu della partita
			this.partita.getGiocatore().setCfu(cfu--); // i cfu vengono decrementati
		}
		console.mostraMessaggio("Ti trovi in: ");
		console.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		console.mostraMessaggio("\nDove vuoi andare?");
	}

	private void fine() {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	
	private boolean prendi(String nomeattr) {
		boolean preso = false;
		if(nomeattr == null) 
			console.mostraMessaggio("Attrezzo non presente in stanza.");;
		preso = partita.getGiocatore().getBorsa().addAttrezzo(partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeattr));
		if(preso) {
			console.mostraMessaggio("L'attrezzo " + nomeattr + " è stato correttamente aggiunto alla borsa.");
		}
		else console.mostraMessaggio("L'attrezzo " + nomeattr + " non è stato aggiunto alla borsa.");
		return preso;
	}
	
	private boolean posa(String nomeattr) {
		boolean posato = false;
		posato = partita.getLabirinto().getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().removeAttrezzo(nomeattr));
		if(posato) {
			console.mostraMessaggio("L'attrezzo " + nomeattr + " è stato correttamente aggiunto alla stanza " + partita.getLabirinto().getStanzaCorrente().getNome());
		}
		else console.mostraMessaggio("L'attrezzo " + nomeattr + " non è stato aggiunto alla stanza " + partita.getLabirinto().getStanzaCorrente().getNome());
		return posato;
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}