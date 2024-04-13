package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	
	private Stanza stanzaCorrente; // è la stanza in cui mi trovo
	private Stanza stanzaVincente; // setto la stanza vincente
	
	public Labirinto() {
		creaStanze();
	}
	
	private void creaStanze() { // crea le stanze ed i collegamenti alle stanze adiacenti

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3); // creo una lanterna di peso 3 kg
		Attrezzo osso = new Attrezzo("osso",1); // creo un osso di peso 1 kg
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
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

		aulaN10.addAttrezzo(lanterna); // aggiungo l'attrezzo lanterna nell'aula N10
		atrio.addAttrezzo(osso); // aggiungo l'attrezzo osso nell'atrio

        stanzaCorrente = atrio;  // la stanza iniziale è sempre l'atrio
		stanzaVincente = biblioteca; // setto come stanza vincente la biblioteca
    }
	
	public Stanza getStanzaVincente() { // ritorna la stanza vincente
		return stanzaVincente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) { //setta la stanza corrente
		this.stanzaVincente = stanzaVincente;
	}
	
	public Stanza getStanzaCorrente() { // ritorna la stanza corrente
		return this.stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) { //setta la stanza corrente
		this.stanzaCorrente = stanzaCorrente;
	}

}
