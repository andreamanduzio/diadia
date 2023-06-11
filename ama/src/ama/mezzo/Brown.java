package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_GIALLO;

import java.awt.Image;
import java.util.Random;

import ama.Citta;
import ama.Posizione;

public class Brown extends Politica{

	static private int progId=0;	
	
	public Brown() {
		super(progId++);
	}

	public Posizione decidiDirezione(Posizione p) {
		return p.traslazioneUnitaria(deltaCasuale(),deltaCasuale());
	}
	
	public Image getImmagine() {
		return IMMAGINE_CAMION_GIALLO;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}

}
