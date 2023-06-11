package battlefield;

import java.util.Comparator;

public class ComparatorePerPosizione implements Comparator<Robot>{

	@Override
	public int compare(Robot r1, Robot r2) {
		int ris = r1.getPosizione().getX() - r2.getPosizione().getX();
		if(ris == 0) {
			ris = r1.getPosizione().getY() - r2.getPosizione().getY();
		}
		return ris;
	}
	

}
