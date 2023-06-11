package battlefield;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class Chaser extends Robot{
	
	public Chaser(Position p) {
		super(p);
	}
	
	public Position decidiMossa(Battlefield field) {
		Walker inseguito = cercaAvversario(field);
		if (inseguito==null) 
			return null; /* nessuno da inseguire: stai fermo */
		else return inseguito.getPosizione();
	}

	private Walker cercaAvversario(Battlefield field) {
		for(Position p : field.adiacenti(this.getPosizione())) {
			Robot vicino = (Robot) field.getRobot(p);
			if (vicino != null && isAvversario(vicino)) {
				return (Walker) vicino;
			}
		}
		return null;
	}

	private boolean isAvversario(Robot avvistato) {
		return (avvistato.getClass() == Walker.class); /* è sicuramente un Walker??? per ora SI! */
	}

	@Override
	public Robot creaClone(Position p) {
		return new Chaser(p);
	}

}

