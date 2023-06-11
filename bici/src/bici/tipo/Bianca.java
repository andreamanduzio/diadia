package bici.tipo;

import static bici.gui.LettoreImmagini.leggiImmagineBici;
import static bici.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;

import bici.sim.Coordinate;
import bici.sim.Zona;

public class Bianca extends Bici{
	
	private static int idProgressivo = 0; //static perchè condivisa da tutte lke implementazioni della classe bianca;
	static final private Image IMMAGINE_BICI_BIANCA = leggiImmagineBici(java.awt.Color.WHITE);
	
	public Bianca(Zona zona) {
		super(zona, idProgressivo++);
	}
	
	protected Coordinate decidiProssimaDestinazione() {
		return posizioneCasuale();
	}
	
	public Image getImmagine() {
		return IMMAGINE_BICI_BIANCA;
	}

}
