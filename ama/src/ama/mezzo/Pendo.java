package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_ROSSO;
import static ama.costanti.CostantiSimulatore.DIMENSIONE;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ama.rifiuto.Rifiuto;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public class Pendo extends Politica {

	static private int progId=0;	
	private Citta citta;
	private boolean toccato;

	public Pendo(Citta citta) {
		super(progId++);
		this.citta = citta;
	}

	public Citta getCitta() {
		return this.citta;
	}

//		@Override
//		public Posizione decidiDirezione(Posizione corrente) {
//			Posizione p = null;
//			int toccato = 0;
//			
//			if(this.getCitta().sulBordo(corrente)) {
//				if(corrente.getX()==0) {
//					p = corrente.traslazioneUnitariaVerso(new Posizione(DIMENSIONE-2, corrente.getY()));
//					toccato = 1;
//				} else {
//					p = corrente.traslazioneUnitariaVerso(new Posizione(1, corrente.getY()));
//					toccato = 2;
//				}
//			} else if(toccato == 1) {
//				p = corrente.traslazioneUnitariaVerso(new Posizione(DIMENSIONE-2, corrente.getY()));
//			}else if(toccato == 2) {			
//				p = corrente.traslazioneUnitariaVerso(new Posizione(1, corrente.getY()));
//			}  else	
//				p = corrente.traslazioneUnitariaVerso(new Posizione(1, corrente.getY()));
//			return p;
//		}

	@Override
	public Posizione decidiDirezione(Posizione corrente) {

		Posizione p1 = new Posizione(corrente.getX()+1, corrente.getY());
		Posizione p2 = new Posizione(corrente.getX()-1, corrente.getY());

		if(!this.getCitta().sulBordo(p1) && !toccato) {
			return corrente.traslazioneUnitaria(1, 0);
		} else if(this.getCitta().sulBordo(p1) && !toccato) {
			this.toccato = true;
			return corrente.traslazioneUnitaria(-1, 0);
		} else if(!this.getCitta().sulBordo(p2) && toccato) {
			return corrente.traslazioneUnitaria(-1, 0);
		} else {
			this.toccato = false;
			return corrente.traslazioneUnitaria(1, 0);
		}
	}
	
	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_ROSSO;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}

}
