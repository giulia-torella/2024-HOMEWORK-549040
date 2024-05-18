package it.uniroma3.diadia.ambienti;

public class Labirinto {
	
	private Stanza stanzaCorrente; 
	private Stanza stanzaVincente; 
	
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}
	
	/*
	private void creaStanze() { 

    	Attrezzo lanterna = new Attrezzo("lanterna",3); 
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo piedediporco = new Attrezzo("piedediporco", 2);
    	
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new StanzaMagica("Aula N11");
		Stanza aulaN10 = new StanzaBloccata("Aula N10", "est", "piedediporco");
		Stanza laboratorio = new StanzaBuia("Laboratorio Campus", "lanterna");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		aulaN10.addAttrezzo(lanterna); 
		atrio.addAttrezzo(osso);
		aulaN11.addAttrezzo(piedediporco);

        stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
    } */
	
	public Stanza getStanzaVincente() { 
		return this.stanzaVincente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) { 
		this.stanzaVincente = stanzaVincente;
	}
	
	public Stanza getStanzaCorrente() { 
		return this.stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) { 
		this.stanzaCorrente = stanzaCorrente;
	}

}
