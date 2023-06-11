package car.sim;

/**
 * Rappresenta le coordinate di  una posizione modellata come coppia di interi 
 * ascissa (x) ed ordinata (y), all'interno di un piano cartesiano.
 * <B>(DA COMPLETARE VEDI DOMANDA 1)</B>
 */
public class Coordinate {

	private int x;

	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	/**
	 * Crea un oggetto {@link Coordinate} traslato rispetto all'originale.
	 * @param dir  direzione verso cui spostarsi (delta su coordinate)
	 * @return il nuovo oggetto {@link Coordinate} traslato 
	 */
	public Coordinate trasla(Direzione dir) {
		return new Coordinate(getX()+dir.getDx(), getY()+dir.getDy());
	}

	@Override
	public int hashCode() {
		/* (DA COMPLETARE VEDI DOMANDA 1) */
		return this.getX() + this.getY();
	}

	@Override
	public boolean equals(Object o){
		/* (DA COMPLETARE VEDI DOMANDA 1) */
		Coordinate that = (Coordinate) o;
		return (this.getX() == that.getX() && this.getY() == that.getY());
	}
	
	public int compareTo(Coordinate that) {
		int ris = this.getX()-that.getX();
		if(ris == 0) {
			ris = this.getY()-that.getY();
		}
		return ris;
	}

	@Override
	public String toString() {
		return "("+getX()+","+getY()+")";
	}

}
