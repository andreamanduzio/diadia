package ant.formica;

import static ant.costanti.CostantiGUI.IMMAGINE_FORMICA_BIANCA;

import java.awt.Image;
import java.util.Set;

import ant.Ambiente;
import ant.Coordinate;
import ant.Direzione;

public class Furba extends Formica {

	static private int progId=0;

	public Furba(Ambiente ambiente) {
		super(ambiente, progId++);
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_FORMICA_BIANCA;
	}

	@Override
	public boolean decideDiCambiareDirezione() {
		return true;
	}

	@Override
	public Direzione cambioDirezione(Set<Direzione> possibili) {
		final Coordinate destinazione = this.getPosizione().trasla(this.getDirezione());
		if (this.getAmbiente().getFerormone(destinazione)!=null)
			/* insisti, c'e' una traccia chimica da seguire: non cambiare direzione */
			return this.getDirezione(); 
		
		/* non c'e' traccia chimica nella direzione corrente; cerca il ferormone vicino */
		final Direzione direzioneFerormone =
			this.getAmbiente().getDirezioneFerormoneVicino(this.getPosizione());

		if (percepitaNuovaTraccia(direzioneFerormone)) 
			return direzioneFerormone;
		else /* traccia chimica persa... */{
			for(Direzione d : possibili ) {
				if(this.getAmbiente().getDirezioneCiboVicino(this.getPosizione())==d)
					return d;	
			}
		}
		return Direzione.scegliAcasoTra(possibili);
 
	}
	
	private boolean percepitaNuovaTraccia(final Direzione direzioneFerormone) {
		/* controlla se c'e' una "nuova" traccia: ma tornare da dove gia' si proveniva non serve */
		return ( direzioneFerormone!=null && !direzioneFerormone.equals(this.getDirezione().opposta()) );
	}

	private Direzione scegliDirezioneDopoPerditaTraccia(Set<Direzione> possibili) {
		/* non e' stato "annusato" nulla: scegli una direzione
		   a caso se non e' possibile proseguire nella corrente */
		if (possibili.contains(this.getDirezione()))
			return this.getDirezione();
		else 
			return Direzione.scegliAcasoTra(possibili);
		/* SUGGERIMENTO: vedi anche domanda 7 */
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}
}