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
public class Attrezzo implements Comparable<Attrezzo>{

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

	@Override
	public boolean equals(Object o) {
		if(o==null) return false;
		if(this.getClass()!=o.getClass()) return false;
		Attrezzo that = (Attrezzo)o;
		return this.getNome().equals(that.getNome()) &&
				this.getPeso()==that.getPeso();
	}
	
	public int HashCode() {
		return this.getPeso() + this.getNome().hashCode();
	}
	

	@Override
	public int compareTo(Attrezzo o) {
		return this.getNome().compareTo(o.getNome());
	}

}