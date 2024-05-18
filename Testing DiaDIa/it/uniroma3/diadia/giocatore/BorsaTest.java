package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePeso;

public class BorsaTest {
	Borsa b;
	Attrezzo torcia;
	Attrezzo martello;
	Attrezzo piuma;
	Attrezzo libro;
	
	@Before
	public void setUp() {
		b = new Borsa();
		torcia = new Attrezzo("torcia",3);
		martello = new Attrezzo("martello",4);
		piuma = new Attrezzo("piuma",0);
		libro = new Attrezzo("libro",3);
	}
	
	
	private Attrezzo attrezzo(String nome, int peso) {
		Attrezzo tool = new Attrezzo(nome, peso);
		return tool;
	}
	
	private Borsa borsa() {
		Borsa bag = new Borsa();
		bag.addAttrezzo(attrezzo("martello", 5));
		return bag;
	}
	
	private Borsa borsa(int pesoMax) {
		Borsa bag = new Borsa();
		bag.setPesoMax(pesoMax);
		return bag;
	}
	
	@Test
	public void testAddAttrezzo() {
		assertFalse(borsa(1).addAttrezzo(attrezzo("osso", 2)));
	}
	
	@Test
	public void testAddAttrezzo2() {
		assertTrue(borsa().addAttrezzo(attrezzo("osso", 2)));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		assertNotNull(borsa().removeAttrezzo("martello"));
	}
	
	@Test
	public void testIsEmpty() {
		assertFalse(borsa().addAttrezzo(null));
	}
	
	@Test
	public void testStessoPesoDiversoNome() {
		assertNotEquals(new Attrezzo("torcia", 4), new Attrezzo("coltello", 4));
	}
	
	@Test
	public void testStessoPesoStessoNome() {
		assertEquals(new Attrezzo("torcia", 4), new Attrezzo("torcia", 4));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoStessoPeso() {
		b.addAttrezzo(torcia);
		b.addAttrezzo(libro);
		List<Attrezzo> expected = new ArrayList<>();
		expected.add(libro);
		expected.add(torcia);
		assertTrue(this.controlloListe(expected, b.getContenutoOrdinatoPerPeso()));
	}
	

	@Test
	public void testGetContenutoOrdinatoPerPesoPesoDiverso() {
		b.addAttrezzo(martello);
		b.addAttrezzo(piuma);
		List<Attrezzo> expected = new ArrayList<>();
		expected.add(piuma);
		expected.add(martello);
		assertTrue(this.controlloListe(expected, b.getContenutoOrdinatoPerPeso()));
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomeStessoPeso() {
		b.addAttrezzo(libro);
		b.addAttrezzo(torcia);
		Set<Attrezzo> expected = new TreeSet<>();
		expected.add(libro);
		expected.add(torcia);
		assertTrue(this.controlloSet(expected, b.getSortedSetOrdinatoPerPeso()));
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomeDiversoPeso() {
		b.addAttrezzo(martello);
		b.addAttrezzo(libro);
		Set<Attrezzo> expected = new TreeSet<>();
		expected.add(libro);
		expected.add(martello);
		assertTrue(this.controlloSet(expected, b.getSortedSetOrdinatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoPesiDiversi() {
		b.addAttrezzo(martello);
		b.addAttrezzo(piuma);
		Map<Integer, Set<Attrezzo>> expected = new TreeMap<>();
		Set<Attrezzo> s1 = new TreeSet<>();
		Set<Attrezzo> s2 = new TreeSet<>();
		s1.add(martello);
		s2.add(piuma);
		expected.put(0, s2);
		expected.put(4, s1);
		assertTrue(this.controlloMappe(expected, b.getContenutoRaggruppatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoStessoPeso() {
		b.addAttrezzo(libro);
		b.addAttrezzo(torcia);
		Map<Integer, Set<Attrezzo>> expected = new TreeMap<>();
		Set<Attrezzo> s1 = new HashSet<>();
		s1.add(libro);
		s1.add(torcia);
		expected.put(3, s1);
		assertTrue(this.controlloMappe(expected, b.getContenutoRaggruppatoPerPeso()));
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziStessoPeso() {
		b.addAttrezzo(torcia);
		b.addAttrezzo(libro);
		Set<Attrezzo> expected = new TreeSet<>(new ComparatorePeso());
		expected.add(libro);
		expected.add(torcia);
		assertArrayEquals(expected.toArray(), b.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziPesoDiverso() {
		b.addAttrezzo(martello);
		b.addAttrezzo(piuma);
		Set<Attrezzo> expected = new TreeSet<>(new ComparatorePeso());
		expected.add(piuma);
		expected.add(martello);
		assertArrayEquals(expected.toArray(), b.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	public boolean controlloListe(List<?> l1, List<?> l2) {
		if(l1.size()!=l2.size())
			return false;
		for(int i = 0; i<l1.size(); i++ ) {
			if(!l1.get(i).equals(l2.get(i)) )
				return false;
		}
		return true;
	}
	
	public boolean controlloSet(Set<Attrezzo> s1, Set<Attrezzo> s2) {
		if(s1.size()!=s2.size())
			return false;
		Iterator<Attrezzo> i = s1.iterator();
		Iterator<Attrezzo> j = s2.iterator();
		while(i.hasNext() && j.hasNext()) {
			if(!i.next().equals(j.next()))
				return false;
		}
		return true;
	}
	
	public boolean controlloMappe(Map<Integer, Set<Attrezzo>> m1, Map<Integer, Set<Attrezzo>> m2) {
		if(m1.size()!=m2.size())
			return false;
		Iterator<Integer> iter1 = m1.keySet().iterator();
		Iterator<Integer> iter2 = m2.keySet().iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!this.controlloSet(m1.get(iter1.next()), m2.get(iter2.next()))) {
				return false;
			}
		}
		return true;
	}

}
