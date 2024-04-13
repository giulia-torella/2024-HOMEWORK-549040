package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10; // peso massimo della borsa
	private Attrezzo[] attrezzi; // array di attrezzi che contiene gli attrezzi
	private int numeroAttrezzi; // numero di attrezzi nella borsa
	private int pesoMax; // peso massimo della borsa
	private Labirinto labirinto;
	private IOConsole console;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
		this.attrezzi = new Attrezzo[10]; 
		this.numeroAttrezzi = 0;
		this.labirinto = new Labirinto();
		this.console = new IOConsole();
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0; // all'inizio ho 0 attrezzi
		this.labirinto = new Labirinto();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo == null) 
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) // se il peso nella borsa più quello dell'oggetto è maggiore del massimo
			return false; // non aggiungo l'attrezzo
		if (this.numeroAttrezzi == 10) // se ho raggiunto il massimo degli attrezzi nella borsa
			return false; // non aggiungo attrezzo
		this.attrezzi[this.numeroAttrezzi] = attrezzo; // aggiungo attrezzo al primo posto dell'array disponibile
		this.numeroAttrezzi++; // incremento numero degli attrezzi
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}
	
	public void setPesoMax(int pesomax) {
		this.pesoMax = pesomax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];

		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) { // estrae attrezzo dalla borsa
		Attrezzo a = null;
		for(int i=0; i<numeroAttrezzi; i++) {
			if(nomeAttrezzo != null)
			    if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
			    	a = this.attrezzi[i];
				    labirinto.getStanzaCorrente().removeElement(this.attrezzi, i);
				    numeroAttrezzi--;
				    console.mostraMessaggio("Ho rimosso " + nomeAttrezzo + " dalla borsa.");
			    }
			else 
				console.mostraMessaggio("Non esiste un attrezzo di nome " + nomeAttrezzo + " nella borsa.");
		}
		if(nomeAttrezzo==null) console.mostraMessaggio("Non hai inserito alcun attrezzo.");
		return a;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for (int i = 0; i < this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString() + " ");
		} else
			s.append("Borsa vuota");
		return s.toString();
	}
}