package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica fabbrica;
	private IO io;
	private Comando comandoDiProva;
	
	@Before
	public void setUp(){
		io = new IOConsole();
		fabbrica = new FabbricaDiComandiFisarmonica();
		comandoDiProva = new ComandoNonValido();
	}
	
	@Test
	public void testComandoNonValido() {
		assertEquals( comandoDiProva.getNome(), fabbrica.costruisciComando("pippo", io).getNome());
	}
	
	@Test
	public void testComandoConParametro() {
		comandoDiProva = new ComandoVai();
		comandoDiProva.setParametro("sud");
		Comando corrente = fabbrica.costruisciComando("vai sud", io);
		assertEquals( comandoDiProva.getNome(), corrente.getNome());
		assertEquals( comandoDiProva.getParametro(), corrente.getParametro());
	}
	
	@Test
	public void testComandoSenzaParametro() {
		comandoDiProva = new ComandoFine();
		assertEquals( comandoDiProva.getNome(), fabbrica.costruisciComando("fine", io).getNome());
	}

}