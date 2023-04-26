package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	Partita partitaDiProva = new Partita();
	Stanza stanzaDiProva = new Stanza("Stanza");
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", partitaDiProva.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		partitaDiProva.getLabirinto().setStanzaCorrente(stanzaDiProva);
		assertEquals(stanzaDiProva, partitaDiProva.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testIsFinita() {
		assertFalse(partitaDiProva.isFinita());
	}
	
}