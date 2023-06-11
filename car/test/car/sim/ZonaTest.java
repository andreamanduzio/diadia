package car.sim;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ZonaTest {
	
	private Zona zona;
	private Coordinate c;

	@Before
	public void setUp() {
		this.zona = new Zona();
		this.c = new Coordinate(3, 3);
		zona.addOstacolo(3, 4);
		zona.addOstacolo(3, 2);
		zona.addOstacolo(2, 3);
	}

	@Test(expected= NullPointerException.class)
	public void testGetPossibiliDirezioniNull() {
		this.zona.getPossibiliDirezioni(null);
	}

	@Test
	public void testEst() {
		Set<Direzione> set = new HashSet<>();
		set.add(Direzione.EST);
		assertEquals(set, this.zona.getPossibiliDirezioni(c));
	}
	
	@Test
	public void testOrigine() {
		Set<Direzione> set = new HashSet<>();
		set.add(Direzione.NORD);
		set.add(Direzione.OVEST);
		assertEquals(set, this.zona.getPossibiliDirezioni(new Coordinate(0, 0)));
	}
}