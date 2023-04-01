package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	Borsa borsaDiProva = new Borsa();
	Attrezzo penna = new Attrezzo("penna", 2);
	Attrezzo scudo = new Attrezzo("scudo", 20);
	
	@Test
	public void testaddAttrezzo() {
		borsaDiProva.addAttrezzo(penna);
		assertEquals(true, borsaDiProva.addAttrezzo(penna));
	}
	
	@Test
	public void testaddAttrezzoDiPesoMaggioreDi10() {
		borsaDiProva.addAttrezzo(scudo);
		assertFalse(borsaDiProva.addAttrezzo(scudo));
	}
	
	@Test
	public void testhasAttrezzo() {
		borsaDiProva.addAttrezzo(penna);
		assertTrue(borsaDiProva.hasAttrezzo("penna"));
	}
	
}
