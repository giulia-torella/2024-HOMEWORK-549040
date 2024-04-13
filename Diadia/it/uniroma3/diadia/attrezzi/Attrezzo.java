package it.uniroma3.diadia.attrezzi;

import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
public class Attrezzo {

	private String nome;
	private int peso;

	public Attrezzo(String nome, int peso) { // crea un attrezzo con this.peso = peso e this.nome = nome
		this.peso = peso;
		this.nome = nome;
	}

	
	public String getNome() { // restituisce il nome dell'attrezzo
		return this.nome;
	}

	
	public int getPeso() { //restituisce il peso dell'attrezzo
		return this.peso;
	}
	

	public String toString() { // restituisce rappresentazione in stringa, nome + (peso kg) dell'attrezzo
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}

}