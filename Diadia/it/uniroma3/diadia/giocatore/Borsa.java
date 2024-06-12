package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Proprieta;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePeso;

public class Borsa {
	static final private int DEFAULT_PESO_MAX_BORSA = Proprieta.getPesoMax();
	private Map<String, Attrezzo> nome2attrezzi;
	private int numeroAttrezzi; // numero di attrezzi nella borsa
	private int pesoMax; // peso massimo della borsa
	private int peso;
	private IO io;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.nome2attrezzi = new TreeMap<>();
		this.numeroAttrezzi = 0;
		this.peso = 0;
		Scanner scanner = new Scanner(System.in);
		io = new IOConsole(scanner);
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo == null) 
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) // se il peso nella borsa più quello dell'oggetto è maggiore del massimo
			return false; // non aggiungo l'attrezzo
		this.nome2attrezzi.put(attrezzo.getNome(), attrezzo); // aggiungo attrezzo al primo posto dell'array disponibile
		this.peso += attrezzo.getPeso();
		this.numeroAttrezzi++; 
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
		if (this.nome2attrezzi.containsKey(nomeAttrezzo))
			a = this.nome2attrezzi.get(nomeAttrezzo);
		return a;
	}

	public int getPeso() {
		return this.peso;
	}
	
	public boolean getPesoRimanente(Attrezzo a) {
		if(a != null && this.getPesoMax()-this.getPeso()>=a.getPeso())
			return true;
		return false; 
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) { 
		if(nomeAttrezzo==null) {
		    io.mostraMessaggio("Non hai inserito alcun attrezzo.");
		    return null;
		}
		Attrezzo attr = null;
		if(nomeAttrezzo != null) {
			attr = this.nome2attrezzi.remove(nomeAttrezzo);
			this.numeroAttrezzi--;
			io.mostraMessaggio("Ho rimosso " + nomeAttrezzo + " dalla borsa.");
		}
		if(attr==null)
		    io.mostraMessaggio("Non esiste l'attrezzo " + nomeAttrezzo + " nella borsa.");
		return attr;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			s.append(this.nome2attrezzi.values() + "\n");
			s.append("Attrezzi ordinati per nome: ");
			s.append(this.getContenutoOrdinatoPerNome().toString() + "\n");
			s.append("Attrezzi ordinati per peso: ");
			s.append(this.getContenutoOrdinatoPerPeso().toString() + "\n");
			s.append("Attrezzi raggruppati per peso: ");
			s.append(this.getContenutoRaggruppatoPerPeso().toString());
		} 
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> l = new ArrayList<>();
		l.addAll(this.nome2attrezzi.values());
		Collections.sort(l, new ComparatorePeso());
		return l;
	}
	
	SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> a = new TreeSet<Attrezzo>(this.nome2attrezzi.values());
		return a;
	}
	
	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer,Set<Attrezzo>> m = new TreeMap<>();
		for(Attrezzo a : this.nome2attrezzi.values()) {
			if(m.containsKey(a.getPeso()))
				m.get(a.getPeso()).add(a);
			else {
				Set<Attrezzo> s = new HashSet<Attrezzo>();
				s.add(a);
				m.put(a.getPeso(), s);
			}
		}
		return m;
	}
	
	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> a = new TreeSet<Attrezzo>(new ComparatorePeso());
		a.addAll(this.nome2attrezzi.values());
		return a;
	}
}