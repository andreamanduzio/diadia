package car.sim;

import java.util.Objects;

import car.auto.Auto;
import car.auto.Bianca;

/**
 * Modella un percorso da un'origine ad una destinazione,
 * entrambe modellate da un oggetto {@link Coordinate} da parte di
 * una generica auto, ad es. ma non solo di tipo {@link Bianca}
 */
public class Tragitto {

	/* DA CAMBIARE VEDI DOMANDA 2 */
	private Auto auto;
	
	private Coordinate origine;

	private Coordinate destinazione;
	
	public Tragitto(Auto auto, Coordinate origine, Coordinate destinazione) {
		this.auto = auto;
		this.origine = origine;
		this.destinazione = destinazione;
	}

	public Auto getAuto() {
		return this.auto;
	}

	public Coordinate getOrigine() {
		return this.origine;
	}

	public Coordinate getDestinazione() {
		return this.destinazione;
	}
	
	
	
	@Override
	public int hashCode() {
		return this.getOrigine().hashCode() + this.getDestinazione().hashCode() + this.getAuto().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		Tragitto that = (Tragitto) o;
		return (this.getOrigine().equals(that.getOrigine()) && this.getDestinazione().equals(that.getDestinazione()) && this.getAuto().equals(that.getAuto()));
	}

	@Override
	public String toString() {
		return this.getOrigine()+"->"+this.getDestinazione();
	}

}
