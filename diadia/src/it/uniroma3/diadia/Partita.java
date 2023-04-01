package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	
	private Giocatore nuovoGiocatore;
	private Labirinto nuovoLabirinto;
	private boolean finita;
	
	public Partita(){
		this.nuovoLabirinto = new Labirinto();
		this.nuovoGiocatore = new Giocatore();
		nuovoLabirinto.creaStanze();
		this.finita = false;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.nuovoLabirinto.getStanzaCorrente()== this.nuovoLabirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.nuovoGiocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Giocatore getGiocatore() {
		return this.nuovoGiocatore;
	}
	
	public void setGiocatore(Giocatore nuovoGiocatore) {
		this.nuovoGiocatore = nuovoGiocatore;
	}
	
	public Labirinto getLabirinto() {
		return this.nuovoLabirinto;
	}
	
	public void setLabirinto(Labirinto nuovoLabirinto) {
		this.nuovoLabirinto = nuovoLabirinto;
	}
}