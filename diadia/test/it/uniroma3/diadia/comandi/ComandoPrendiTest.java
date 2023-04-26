package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	private Partita partitaDiProva;
	private Attrezzo attrezzoDiProva;
	private Attrezzo attrezzoDiProvaPesante;
	private Attrezzo attrezzoDiProvaNull;
	private Comando comandoDiProva;
	private IO io;
	
	@Before
	public void setUp() {
		partitaDiProva = new Partita();
		attrezzoDiProva = new Attrezzo("lanterna", 2);
		attrezzoDiProvaPesante = new Attrezzo("piedediporco", 17);
		attrezzoDiProvaNull = null;
		comandoDiProva = new ComandoPrendi();
		io = new IOConsole();
		comandoDiProva.setIo(io);
	}
	
	public boolean attrezzoPresente(String s) {
		Attrezzo[] array = partitaDiProva.getStanzaCorrente().getAttrezzi();
		for(Attrezzo a : array) {
			if(a != null && s.equals(a.getNome()))
					return true;
		}
		return false;
	}
	
	@Test
	public void testAttrezzoPreso() {
		partitaDiProva.getStanzaCorrente().addAttrezzo(attrezzoDiProva);
		comandoDiProva.setParametro("lanterna");
		comandoDiProva.esegui(partitaDiProva);
		assertFalse(attrezzoPresente("lanterna"));
	}
	@Test
	public void testAttrezzoNonPresente() {
		comandoDiProva.setParametro("lanterna");
		comandoDiProva.esegui(partitaDiProva);
		assertFalse(attrezzoPresente("lanterna"));
	}
	
	@Test
	public void testAttrezzoPesante() {
		partitaDiProva.getStanzaCorrente().addAttrezzo(attrezzoDiProvaPesante);
		comandoDiProva.setParametro("piedediporco");
		comandoDiProva.esegui(partitaDiProva);
		assertTrue(attrezzoPresente("piedediporco"));
	}
	
}