package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto{
	
	private Labirinto labirinto;
	private Stanza aggiunta;
	private Map<String, Stanza> nome2stanza;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.nome2stanza = new HashMap<String, Stanza>();
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public Map<String, Stanza> getNome2stanza() {
		return nome2stanza;
	}
	
	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza room = new Stanza(stanzaIniziale);
		this.labirinto.setStanzaCorrente(room);
		this.aggiungi(room);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza room = new Stanza(stanzaVincente);
		this.labirinto.setStanzaVincente(room);
		this.aggiungi(room);
		return this;
	}
	
	public LabirintoBuilder addStanza(String stanza) {
		Stanza room = new Stanza(stanza);
		this.aggiungi(room);
		return this;
	}	
	
	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
		Attrezzo tool = new Attrezzo(attrezzo, peso);
		if(this.aggiunta==null)
			return this;
		this.aggiunta.addAttrezzo(tool);
		return this;
	}
	
	public LabirintoBuilder addAdiacente(String stanzaCorrente, String stanzaAdiecente, String direzione) {
		Stanza s1 = this.nome2stanza.get(stanzaCorrente);
		Stanza s2 = this.nome2stanza.get(stanzaAdiecente);
		if(s1 != null) s1.impostaStanzaAdiacente(direzione, s2);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nome) {
		Stanza room = new StanzaMagica(nome);
		this.aggiungi(room);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
		Stanza room = new StanzaBuia(nome,attrezzoPerVedere);
		this.aggiungi(room);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
		Stanza room = new StanzaBloccata(nome, attrezzoSbloccante, direzioneBloccata);
		this.aggiungi(room);
		return this;
	}
	
	public void aggiungi(Stanza stanza) {
		this.aggiunta = stanza;
		this.nome2stanza.put(stanza.getNome(), stanza);
	}

}
