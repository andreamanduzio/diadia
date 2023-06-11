package car.auto;

import static car.gui.LettoreImmagini.leggiImmagineVettura;
import static car.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;
import java.util.Objects;
import java.util.Set;

import car.sim.Coordinate;
import car.sim.Direzione;
import car.sim.Tragitto;
import car.sim.Zona;

/**
 * Modella le fasi del ciclo di vista di una vettura {@link Bianca}.
 * <B>(VEDI DOMANDA 2)</B>
 */
public class Bianca extends Auto{
	
	static final private Image IMMAGINE_VETTURA_BIANCA = leggiImmagineVettura(java.awt.Color.WHITE);

	static private int progId = 0;

	private Zona zona;

	public Bianca(Zona zona) {		
		super(zona, progId++);
	}

	protected Coordinate decidiProssimaDestinazione() {
		return posizioneCasuale();
	}
	
	public Image getImmagine() {
		return IMMAGINE_VETTURA_BIANCA;
	}

}
