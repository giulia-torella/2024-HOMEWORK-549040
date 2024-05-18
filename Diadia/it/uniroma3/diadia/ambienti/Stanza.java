package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4; // 4 direzioni, nord sud est ed ovest
	static final private int NUMERO_MASSIMO_ATTREZZI = 10; // al massimo 10 attrezzi per stanza
	
	private String nome; // ha un nome
	private Map<String, Attrezzo> nome2attrezzi;
    private int numeroAttrezzi;
    private int numeroStanzeAdiacenti; // il numero di stanze adiacenti alla stanza
	private Map<String, Stanza> direzioni2stanze;
	private IO io = new IOConsole();
    
 
    public Stanza(String nome) { // crea una stanza
        this.nome = nome; // avrà il nome che gli passo come parametro
        this.numeroStanzeAdiacenti = 0; // all'inizio il numero delle stanze adiacenti è 0
        this.numeroAttrezzi = 0; // all'inizio il numero degli attrezzi è 0
        this.direzioni2stanze = new HashMap<>();
        this.nome2attrezzi = new HashMap<>();
    }

    public void impostaStanzaAdiacente(String direzione, Stanza stanza) { // passo la direzione in cui voglio metterla e la stanza che sarà adiacente in quella direzione
        boolean impostato = false; 
        if(this.direzioni2stanze.containsKey(direzione)) {
        	this.direzioni2stanze.put(direzione, stanza);
        	impostato = true;
        }
    	if (!impostato) // se l'aggiornamento non è andato a buon fine (non è entrato nell'if)
    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) { 
    			this.direzioni2stanze.put(direzione, stanza); // aggiungo stanza alla prima direzione disponibile
    		    this.numeroStanzeAdiacenti++; // incremento il numero delle stanze adiacenti avendone ora aggiunta un'altra (stanza)
    		}
    }

    public List<Stanza> getStanzeAdiacenti() {
		return (List<Stanza>) direzioni2stanze.values();
	}

    public String getNome() { // ritorna il nome della stanza corrente
        return this.nome; 
    }

    public String getDescrizione() { // ritorna la descrizione in stringa della stanza
        return this.toString();
    }

    public Collection<Attrezzo> getAttrezzi() {
		return this.nome2attrezzi.values();
	}

    public boolean addAttrezzo(Attrezzo attrezzo) { // aggiunge un attrezzo alla stanza corrente
    	if(attrezzo == null) 
    		return false;
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) { // se il numero degli attezzi nella stanza è minore del massimo consentito
        	this.nome2attrezzi.put(attrezzo.getNome(), attrezzo);
        	this.numeroAttrezzi++; // incremento il numero degli attrezzi della stanza
        	return true; // ritorno che l'aggiunta è andata a buon fine
        }
        else {
        	return false; // altrimenti ritorno che non è andata a buon fine (non è entrato nell'if perche massimo consentito raggiunto)
        }
    }

    public String toString() { // ritorna una rappresentazione in stringa della stanza corrente(descrizione, uscite e eventuali attrezzi)
    	StringBuilder risultato = new StringBuilder(); 
    	risultato.append("Ti trovi in: " + this.nome); // stampa il nome della stanza
    	risultato.append("\nUscite: ");
    	risultato.append(this.getDirezioni().toString());
    	risultato.append("\nAttrezzi nella stanza: ");
    	risultato.append(this.getAttrezzi().toString());
    	return risultato.toString(); // ritorna la rappresentazione
    }

	public boolean hasAttrezzo(String nomeAttrezzo) { // controlla se un attrezzo è presente nella stanza
		return this.nome2attrezzi.containsKey(nomeAttrezzo);
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) { // restituisce l'attrezzo se presente nella stanza (altrimenti null)
		Attrezzo attrezzo;
		attrezzo = null; // creo un elemento di tipo Attrezzo inizializzato a null
		if(this.nome2attrezzi.containsKey(nomeAttrezzo))
			attrezzo = this.nome2attrezzi.get(nomeAttrezzo);
		return attrezzo;	// ritorno l'elemento, che può anche essere null
	}


	public Attrezzo removeAttrezzo(Attrezzo attrezzo) { 
		Attrezzo attr = null;
		if(attrezzo != null) {
			attr = this.nome2attrezzi.remove(attrezzo.getNome());
			if(attr!=null) {
				io.mostraMessaggio("Ho rimosso " + attrezzo.getNome() + " dalla stanza.");
				return attr;
			}
			else {
				io.mostraMessaggio("Non esiste un attrezzo " + attrezzo.getNome() + " nella stanza.");
				return null;
			}
		}
		io.mostraMessaggio("Non hai specificato alcun attrezzo da rimuovere.");
		return null;
	}


	public Set<String> getDirezioni() { // ritorna le direzioni raggiungibili dalla stanza
		return this.direzioni2stanze.keySet();
    }
	
	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI-this.numeroAttrezzi;
	}
	
	public int getNumeroAttrezziCorrente() {
		return this.numeroAttrezzi;
	}

	public Stanza getStanzaAdiacente(String dir) {
		Stanza stanza = null;
		if(this.direzioni2stanze.containsKey(dir)) 
			stanza = this.direzioni2stanze.get(dir);
		return stanza;
	}

}