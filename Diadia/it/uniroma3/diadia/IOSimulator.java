package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {

	private List<String> righeDaLeggere;
	private int index;

	public List<String> getMessaggiProdotti() {
		return this.generati;
	}

	/* Per ricordare per ogni riga letta i messaggi prodotti sarebbe
	   utile utilizzare le mappe */
	public void setMessaggiProdotti(List<String> messaggiProdotti) {
		this.generati = messaggiProdotti;
	}
	
	private List<String> generati;
	private int indexGenerati;
	private int indexLetti;

	public IOSimulator(List<String> righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.index = 0;
		this.indexLetti = 0;
		this.generati = new ArrayList<String>();
	}

	@Override
	public String leggiRiga() {
		String riga = null;
		riga = this.righeDaLeggere.get(index);
		this.index++;
		return riga;
	}

	@Override
	public void mostraMessaggio(String msg) {
		this.generati.add(this.indexGenerati, msg);
		this.indexGenerati++;
	}

	public String nextMessaggio() {
		String next = this.generati.get(indexLetti);
		this.indexLetti++;
		return next;
	}

	public boolean hasNextMessaggio() {
		return this.indexLetti < this.indexGenerati;
	}

}