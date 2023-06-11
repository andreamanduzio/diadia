package bici.tipo;

import static bici.gui.LettoreImmagini.leggiImmagineBici;
import static bici.sim.GeneratoreCasuale.posizioneCasuale;
import static bici.sim.CostantiSimulazione.N_DESTINAZIONI;

import java.awt.Image;
import java.util.List;
import java.util.Random;

import bici.sim.Coordinate;
import bici.sim.GeneratoreCasuale;
import bici.sim.Zona;

public class Gialla extends Bici{
	
	private static int idProgressivo = 0; //static perchè condivisa da tutte lke implementazioni della classe bianca;
	static final private Image IMMAGINE_BICI_GIALLA = leggiImmagineBici(java.awt.Color.YELLOW);
	private static List<Coordinate> destinazioniAmmissibili = GeneratoreCasuale.generaNposizioniCasuali(N_DESTINAZIONI); //ho creato una lista delle destinazioni ammissibili delle bici gialle
	static final private Random random = new Random();

	public Gialla(Zona zona) {
		super(zona, idProgressivo++);
		// TODO Auto-generated constructor stub
	}
	protected Coordinate decidiProssimaDestinazione() { //prende una delle destinazioni ammissibili e la sceglie a caso
		int next = random.nextInt(destinazioniAmmissibili.size()); //prendiamo un intero randomico da 0 alla dimensione della lista
		return destinazioniAmmissibili.get(next); //ritorniamo questo intero casuale
	}
	
	public Image getImmagine() {
		return IMMAGINE_BICI_GIALLA;
	}
	
	public static List<Coordinate> getDestinazioniAmmissibili() {
		return destinazioniAmmissibili;
	}
	
	public static void setDestinazioniAmmissibili(List<Coordinate> destinazioniAmmissibili) {
		Gialla.destinazioniAmmissibili = destinazioniAmmissibili;
	}
}
