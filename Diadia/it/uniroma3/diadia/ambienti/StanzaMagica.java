package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;;

public class StanzaMagica extends Stanza{
	
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	final static private int SOGLIA_MAGICA_DEFAULT = 3;

	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.sogliaMagica = soglia;
		this.contatoreAttrezziPosati = 0;
	}
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),
		pesoX2);
		return attrezzo;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.contatoreAttrezziPosati > this.sogliaMagica) {
			if (attrezzo != null)
				attrezzo = this.modificaAttrezzo(attrezzo);
		}
		this.contatoreAttrezziPosati++;
		return super.addAttrezzo(attrezzo); // il controllo per l'aggiunta lo lascio alla superclasse
	}
}
