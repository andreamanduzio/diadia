package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiocatoreTest {
	Giocatore nuovoGiocatore = new Giocatore();

	@Test
	public void testsetCfu() {
		nuovoGiocatore.setCfu(30);
		assertEquals(30, nuovoGiocatore.getCfu());
	}
	
	@Test
	public void testgetCfu() {
		assertEquals(20, nuovoGiocatore.getCfu());
	}
	
	@Test
	public void testgetBorsa() {
		assertNotNull(nuovoGiocatore.getBorsa());
	}
	

}
