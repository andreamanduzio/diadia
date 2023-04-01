package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.*;

public class PartitaTest {
	Partita partitaDiProva = new Partita();
	Stanza stanzaDiProva = new Stanza("stanzaDiProva");

	@Test
	public void testisFinita() {
		assertFalse(partitaDiProva.isFinita());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", partitaDiProva.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testsetStanzaCorrente() {
		partitaDiProva.getLabirinto().setStanzaCorrente(stanzaDiProva);
		assertEquals(stanzaDiProva, partitaDiProva.getLabirinto().getStanzaCorrente());
	}
}
	