package it.uniroma3.diadia.giocatore;

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	private int cfu; // cfu posseduti
	private Borsa borsa;
	
	public Giocatore() {
		setCfu(CFU_INIZIALI);
		this.borsa = new Borsa();
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public int getCfu() { // ritorna il numero dei cfu
		return this.cfu;
	}

	public void setCfu(int cfu) { // setta il numero dei cfu
		this.cfu = cfu;		
	}	

}
