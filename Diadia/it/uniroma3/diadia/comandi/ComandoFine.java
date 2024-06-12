package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando{
	
	private final static String NOME = "fine";
	private final static String MESSAGGIO_FINALE = "Grazie per aver giocato!";

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		this.getIo().mostraMessaggio(MESSAGGIO_FINALE);
	}
	
	public static String mostraMessaggioFinale() {
		return MESSAGGIO_FINALE;
	} 

	@Override
	public String getNome() {
		return NOME;
	}

}
