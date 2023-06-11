package bici.tipo;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import bici.sim.Coordinate;
import bici.sim.Zona;

public class GiallaTest {
	private Bici gialla;

	@Before
	public void setUp() throws Exception {
		gialla = new Gialla(new Zona());
	}

	@Test
	public void testDecidiProssimaDestinazione() {
		assertTrue(Gialla.getDestinazioniAmmissibili().contains(gialla.decidiProssimaDestinazione()));
	}
	
	@Test
	public void testDecidiProssimaDestinazioneSingolaDestinazione() {
		Gialla.setDestinazioniAmmissibili(Collections.singletonList(new Coordinate(0,0)));
		assertEquals(new Coordinate(0,0),gialla.decidiProssimaDestinazione());
	}
}
