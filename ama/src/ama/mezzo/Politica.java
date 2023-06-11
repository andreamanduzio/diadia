package ama.mezzo;

import java.awt.Image;
import java.util.Random;

import ama.Posizione;

public abstract class Politica {

	private int id;

	final protected Random rnd;

	public Politica(int id) {
		this.id = id;
		this.rnd = new Random();
	}
	
	public int getId() {
		return this.id;
	}
	
	public abstract Posizione decidiDirezione(Posizione corrente);

	public abstract Image getImmagine();
	
	//public abstract String toString();

	/**
	 * 
	 * @return un numero intero casuale tra -1,0,+1
	 */
	protected int deltaCasuale() {
		return this.rnd.nextInt(3)-1;
	}

}