package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

/**
 * Classe che modella una stanza, che e' un luogo fisico nel gioco di ruolo.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class StanzaProtected {
	
	static final protected int NUMERO_MASSIMO_DIREZIONI = 4; // 4 direzioni, nord sud est ed ovest
	static final protected int NUMERO_MASSIMO_ATTREZZI = 10; // al massimo 10 attrezzi per stanza
	
	protected String nome; // ha un nome
    protected Attrezzo[] attrezzi; // un array di attrezzi
    protected int numeroAttrezzi; // il numero di attrezzi presenti nella stanza
    protected Stanza[] stanzeAdiacenti; // un array di stanze adiacenti
    protected int numeroStanzeAdiacenti; // il numero di stanze adiacenti alla stanza
	protected String[] direzioni; // un array di direzioni possibili
	protected IO io = new IOConsole();
    
 
    public StanzaProtected(String nome) { // crea una stanza
        this.nome = nome; // avrà il nome che gli passo come parametro
        this.numeroStanzeAdiacenti = 0; // all'inizio il numero delle stanze adiacenti è 0
        this.numeroAttrezzi = 0; // all'inizio il numero degli attrezzi è 0
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI]; // le direzioni possibili saranno un'array con lunghezza il num max delle direzioni
        this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI]; // le stanze adiacenti saranno un'array con lunghezza il num max delle direzioni
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI]; // gli attrezzi saranno un'array con lunghezza il num max degli attrezzi possibili
    }

    public void impostaStanzaAdiacente(String direzione, Stanza stanza) { // passo la direzione in cui voglio metterla e la stanza che sarà adiacente in quella direzione
        boolean aggiornato = false; // non ho cambiato niente
    	for(int i=0; i<this.direzioni.length; i++) // scorro l'array delle direzioni della stanza corrente
			if (direzione != null)
				if (direzione.equals(this.direzioni[i])) { // se la direzione passata è presente nell'array delle									// direzioni in posizione i
					this.stanzeAdiacenti[i] = stanza; // la stanza passata è la nuova stanza adiacente nella posizione									// i, che è la stessa della direzione
					aggiornato = true; // ho aggiunto la stanza
				}
    	if (!aggiornato) // se l'aggiornamento non è andato a buon fine (non è entrato nell'if)
    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) { // se il numero delle stanze adiacenti è minore del massimo delle direzioni
    			this.direzioni[numeroStanzeAdiacenti] = direzione; // la direzione passata viene messa al primo posto libero dell'array direzioni
    			this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza; // la stanza passata viene messa al primo posto libero dell'array delle stanze adiacenti
    		    this.numeroStanzeAdiacenti++; // incremento il numero delle stanze adiacenti avendone ora aggiunta un'altra (stanza)
    		}
    }

	public Stanza getStanzaAdiacente(String direzione) { // restituisce la stanza adiacente rispetto alla direzione specificata
        Stanza stanza = null; // creo una stanza di tipo Stanza = null che userò per scorrere nel for
		for(int i=0; i<this.numeroStanzeAdiacenti; i++) // scorro fino al numero delle stanze adiacenti
			if (this.direzioni[i] != null)
				if (this.direzioni[i].equals(direzione)) // se nell'array della direzione c'è un elemento uguale alla								// direzione passata per parametro
					stanza = this.stanzeAdiacenti[i]; // la stanza prima inizializzata a null ora è la stanza adiacente								// in posizione i (uguale a direzione)
        return stanza; // ritorna tale stanza
	}

    public String getNome() { // ritorna il nome della stanza corrente
        return this.nome; 
    }

    public String getDescrizione() { // ritorna la descrizione in stringa della stanza
        return this.toString();
    }

    public Attrezzo[] getAttrezzi() { // restituisce gli attezzi presenti nella stanza
        return this.attrezzi;
    }

    public boolean addAttrezzo(Attrezzo attrezzo) { // aggiunge un attrezzo alla stanza corrente
    	if(attrezzo == null) 
    		return false;
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) { // se il numero degli attezzi nella stanza è minore del massimo consentito
        	this.attrezzi[numeroAttrezzi] = attrezzo; // nella prima posizione libera dell'array aggiungo l'attrezzo passato 
        	this.numeroAttrezzi++; // incremento il numero degli attrezzi della stanza
        	return true; // ritorno che l'aggiunta è andata a buon fine
        }
        else {
        	return false; // altrimenti ritorno che non è andata a buon fine (non è entrato nell'if perche massimo consentito raggiunto)
        }
    }

    public String toString() { // ritorna una rappresentazione in stringa della stanza corrente(descrizione, uscite e eventuali attrezzi)
    	StringBuilder risultato = new StringBuilder(); 
    	risultato.append(this.nome); // stampa il nome della stanza
    	risultato.append("\nUscite: ");
    	for (String direzione : this.direzioni)
    		if (direzione!=null)
    			risultato.append(" " + direzione); // stampa le direzioni raggiungibili dalla stanza
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (Attrezzo attrezzo : this.attrezzi) {
    		if(attrezzo!=null)
    		    risultato.append(attrezzo.toString()+" "); // stampa gli attrezzi presenti nella stanza
    	}
    	return risultato.toString(); // ritorna la rappresentazione
    }

	public boolean hasAttrezzo(String nomeAttrezzo) { // controlla se un attrezzo è presente nella stanza
		boolean trovato;
		trovato = false; // all'inizio l'oggetto non è stato trovato
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo.getNome().equals(nomeAttrezzo)) // se il nome dell'attrezzo eguaglia il nome dell'attrezzo passato per parametro
				trovato = true; // allora l'ho trovato
			    return trovato; // ritorno trovato = true
		}
		return trovato; //ritorno il valore booleano di trovato
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) { // restituisce l'attrezzo se presente nella stanza (altrimenti null)
		Attrezzo attrezzoCercato;
		attrezzoCercato = null; // creo un elemento di tipo Attrezzo inizializzato a null
		for (Attrezzo attrezzo : this.attrezzi) { // scorro gli attrezzi della stanza
			 if(attrezzo != null)
			     if (attrezzo.getNome().equals(nomeAttrezzo)) // se il nome dell'attrezzo eguaglia il nome dell'attrezzo passato per parametro
				     attrezzoCercato = attrezzo; // attrezzoCercato viene inizializzato con l'attrezzo trovato
		}
		return attrezzoCercato;	// ritorno l'elemento, che può anche essere null
	}

	/* IMPLEMENTATO IO */
	public Attrezzo removeAttrezzo(Attrezzo attrezzo) { // estrae attrezzo dalla stanza
		Attrezzo a = null;
		for(int i=0; i<numeroAttrezzi; i++) {
			if(attrezzo != null)
			    if(this.attrezzi[i].getNome().equals(attrezzo.getNome())) {
			    	a = this.attrezzi[i];
				    removeElement(this.attrezzi, i);
				    numeroAttrezzi--;
				    io.mostraMessaggio("Ho rimosso " + attrezzo + " dalla stanza.");
				    io.mostraMessaggio("Ho aggiunto " + attrezzo + " alla tua borsa");
			    }
			else 
				io.mostraMessaggio("Non esiste un attrezzo di nome " + attrezzo + " nella stanza.");
		}
		return a;
	}
	
	public void removeElement(Attrezzo[] attrezzi, int index) {
		Attrezzo arr[] = new Attrezzo[attrezzi.length - 1];
		int rimanenti = attrezzi.length - (index + 1);
		System.arraycopy(attrezzi, 0, arr, 0, index);
		System.arraycopy(attrezzi, index+1, arr, index, rimanenti);
		for(int i=0; i<arr.length; i++) {
			attrezzi[i] = arr[i];
			for(int j=arr.length; j<attrezzi.length; j++) {
				attrezzi[j] = null;
			}
		}
	}


	public String[] getDirezioni() { // ritorna le direzioni raggiungibili dalla stanza
		String[] direzioni = new String[this.numeroStanzeAdiacenti]; // creo stringa di direzioni di lunghezza pari al numero delle stanze adiacenti
	    for(int i=0; i<this.numeroStanzeAdiacenti; i++) // scorro for
	    	direzioni[i] = this.direzioni[i]; // copio nel nuovo array le direzioni della stanza
	    return direzioni; // ritorno le direzioni
    }
	
	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI-this.numeroAttrezzi;
	}
	
	public int getNumeroAttrezziCorrente() {
		return this.numeroAttrezzi;
	}

}