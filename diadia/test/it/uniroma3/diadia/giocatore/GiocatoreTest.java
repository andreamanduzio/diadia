package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	Giocatore giocatoreDiProva = new Giocatore();
	
	@Test
	public void testGetCfuDefault() {
		assertEquals(20, giocatoreDiProva.getCfu());
	}
	
	@Test
	public void testSetCfu() {
		giocatoreDiProva.setCfu(3);
		assertEquals(3, giocatoreDiProva.getCfu());
	}

	@Test
	public void testGetBorsaDefault() {
		assertNotNull(giocatoreDiProva.getBorsa());
	}
}

