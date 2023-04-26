package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiutoTest {
	private Partita partitaDiProva;
	private IO io;
	private Comando comandoDiProva;

	@Before
	public void setUp() {
		partitaDiProva = new Partita();
		comandoDiProva = new ComandoAiuto();
		io = new IOConsole();
		comandoDiProva.setIo(io);
	}
	
	@Test
	public void testComandoFine() {
		comandoDiProva.setParametro("aiuto");
		//comandoDiProva.esegui(partitaDiProva);
		assertEquals("aiuto", comandoDiProva.getNome());
	}

}