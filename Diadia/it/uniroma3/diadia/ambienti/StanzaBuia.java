package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{
	
	private String attrezzoLuminoso;

	public StanzaBuia(String nome, String attrezzoLuminoso) {
		super(nome);
		this.attrezzoLuminoso = attrezzoLuminoso;
	}
	
	@Override
	public String getDescrizione() { 
		String buio = new String("Qui c'è buio pesto...");
		for(Attrezzo a: this.getAttrezzi()) {
			if(a != null) {
				if(a.getNome().equals(attrezzoLuminoso)) return super.getDescrizione();
			}
		}
		return buio;
    }
}
