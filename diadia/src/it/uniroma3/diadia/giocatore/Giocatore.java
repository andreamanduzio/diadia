package it.uniroma3.diadia.giocatore;

public class Giocatore {
	private int cfu;
	static final private int CFU_INIZIALI = 20;
	private Borsa borsa;
	
	public Giocatore() {
		this.borsa = new Borsa();
		this.cfu = CFU_INIZIALI;
	}
	public int getCfu() {
		return this.cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	public Borsa getBorsa() {
		return this.borsa;
	}
}