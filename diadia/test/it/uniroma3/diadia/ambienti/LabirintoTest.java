package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	Labirinto l;
	Stanza biblioteca;
	Stanza A10;

	@Before
	public void setUp() {
		l = new Labirinto();
		l.creaStanze();
		biblioteca = new Stanza("Biblioteca");
		A10 = new Stanza("A10");
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(A10);
		assertEquals(A10, l.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}

}
