package bici.stats;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import bici.sim.Coordinate;
import bici.sim.Percorso;
import bici.sim.Zona;
import bici.stats.Statistiche;
import bici.tipo.Bici;
import bici.tipo.Gialla;

public class StatisticheTest {

	@SuppressWarnings("unused")
	private Statistiche stats;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
	}
	
	@Test
	public void testPercorsoPerBiciVuoto() {
		assertTrue(this.stats.percorsiPerBici(Collections.emptySet()).isEmpty());
	}
	
	@Test
	public void testPercorsoPerBiciNonVuoto() {
		Zona zona = new Zona();
		Bici gialla = new Gialla(zona);
		Percorso single = new Percorso(gialla ,new Coordinate(0,0), new Coordinate(1,1));
		assertFalse(this.stats.percorsiPerBici(Collections.singleton(single)).isEmpty());
	}

}