package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	Borsa borsaDiProva = new Borsa();
	Attrezzo lanterna;
	Attrezzo osso;
	
	@Before
	public void setUp() {
		lanterna = new Attrezzo("lanterna", 20);
		osso = new Attrezzo("osso", 1);
	}

	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(borsaDiProva.addAttrezzo(osso));

	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(borsaDiProva.addAttrezzo(lanterna));

	}
	
	@Test
	public void testGetPeso() {
		borsaDiProva.addAttrezzo(osso);
		assertEquals(osso, borsaDiProva.getAttrezzo("osso"));

	}
}
