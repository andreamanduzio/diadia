package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {

	private Stanza s1;
	private Stanza s2;
	private Comando vai;
	private Partita partitaDiProva;
	
	@Before
	public void setUp() {
		s1 = new Stanza("biblioteca");
		s2 = new Stanza("atrio");
		vai = new ComandoVai();
		partitaDiProva = new Partita();
		vai.setIo(new IOConsole());
	}

	@Test
	public void testVaiNull() {
		partitaDiProva.setStanzaCorrente(s1);
		vai.esegui(partitaDiProva);
		assertEquals(s1, partitaDiProva.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneEsistente() {
		partitaDiProva.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud-ovest", s2);
		vai.setParametro("sud-ovest");
		vai.esegui(partitaDiProva);
		assertEquals(s2, partitaDiProva.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneInesistente() {
		partitaDiProva.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud-ovest", s2);
		vai.setParametro("in fondo a destra");
		vai.esegui(partitaDiProva);
		assertNotEquals(s2, partitaDiProva.getStanzaCorrente());
	}
}
