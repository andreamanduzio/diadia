package car.stats;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import car.auto.Auto;
import car.auto.Gialla;
import car.sim.Coordinate;
import car.sim.Tragitto;
import car.sim.Zona;

public class StatisticheTest {

	private Statistiche stats;
	private List<Tragitto> lista;
	private Tragitto t;
	private Tragitto t2;
	private Auto gialla;
	private Coordinate c1;
	private Coordinate c2;
	private Coordinate c3;
	private Coordinate c4;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
		this.lista = new ArrayList<Tragitto>();
		this.c1 = new Coordinate(0, 0);
		this.c2 = new Coordinate(2, 0);
		this.c3 = new Coordinate(3, 3);
		this.c4 = new Coordinate(4, 4);
		this.gialla = new Gialla(new Zona());
		this.t = new Tragitto(gialla, c1, c2);
		this.t2 = new Tragitto(gialla, c3, c4);
		lista.add(t);
		lista.add(t2);
	}

	@Test
	public void testTragittoPerAutoVuoto() {
		assertEquals(Collections.emptyMap(), this.stats.tragittoPerAuto(Collections.emptyList()));
	}

	@Test
	public void testTragittoPerUnAuto() {
		assertEquals(1, this.stats.tragittoPerAuto(Collections.singletonList(new Tragitto(gialla, c1, c2))).size());
	}
	
	@Test
	public void testTragittoPerUnAutoDueTragitti() {
		assertEquals(2, this.stats.tragittoPerAuto(lista).get(gialla).size());
	}
}