package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

	private Partita partitaDiProva;
	private Attrezzo attrezzoDiProva;
	private IO io;
	private Comando comandoDiProva;

	@Before
	public void setUp() {
		partitaDiProva = new Partita();
		attrezzoDiProva = new Attrezzo("lanterna", 3);
		comandoDiProva = new ComandoPosa();
		io = new IOConsole();
		comandoDiProva.setIo(io);
	}

	@Test
	public void testAttrezzoPosato() {
		partitaDiProva.getGiocatore().getBorsa().addAttrezzo(attrezzoDiProva);
		comandoDiProva.setParametro("lanterna");
		comandoDiProva.esegui(partitaDiProva);
		assertTrue(partitaDiProva.getStanzaCorrente().hasAttrezzo("lanterna"));
	}

	@Test
	public void testAttrezzoPosatoNull() {
		comandoDiProva.setParametro("lanterna");
		comandoDiProva.esegui(partitaDiProva);
		assertFalse(partitaDiProva.getStanzaCorrente().hasAttrezzo("lanterna"));
	}

}