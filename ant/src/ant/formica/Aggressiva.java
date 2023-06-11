package ant.formica;

import java.awt.Image;
import java.util.Set;
import static ant.costanti.CostantiGUI.IMMAGINE_FORMICA_ROSSA;
import static ant.costanti.CostantiSimulazione.PROBABILITA_CAMBIO_DIREZIONE;

import static ant.simulatore.GeneratoreCasuale.siVerificaEventoDiProbabilita;

import java.awt.Image;
import java.util.Set;

import ant.Ambiente;
import ant.Cibo;
import ant.Coordinate;
import ant.Direzione;
import ant.Formicaio;


import ant.Direzione;

public class Aggressiva extends Formica {
	static private int progId=0;

	public Aggressiva(Ambiente ambiente) {
		super(ambiente, progId++);
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_FORMICA_ROSSA;
	}

	@Override
	public boolean decideDiCambiareDirezione() {
		return true;
	}

	@Override
	public Direzione cambioDirezione(Set<Direzione> possibili) {
		for(Direzione d : possibili ) {
			if(this.getAmbiente().getDirezioneCiboVicino(this.getPosizione())==d)
				return d;	
		}
		return Direzione.scegliAcasoTra(possibili);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}


}