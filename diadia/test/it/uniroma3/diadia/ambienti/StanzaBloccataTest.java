package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata stanzaDiProvaBloccata;
	private Stanza stanzaDiProva;
	private Attrezzo attrezzoDiProva;
	
	@Before
	public void setUp() {
		stanzaDiProvaBloccata = new StanzaBloccata("StanzaBloccata", "ovest", "piedediporco");
		stanzaDiProva = new Stanza("Stanzetta");
		attrezzoDiProva = new Attrezzo("piedediporco", 1);
		stanzaDiProvaBloccata.impostaStanzaAdiacente("ovest", stanzaDiProva);
		
	}

	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(stanzaDiProvaBloccata, stanzaDiProvaBloccata.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		stanzaDiProvaBloccata.addAttrezzo(attrezzoDiProva);
		assertEquals(stanzaDiProva, stanzaDiProvaBloccata.getStanzaAdiacente("ovest"));
		
	}

	@Test
	public void testGetDescrizioneDirezioneSbloccata() {
		stanzaDiProvaBloccata.addAttrezzo(attrezzoDiProva);
		assertEquals(stanzaDiProvaBloccata.toString(), stanzaDiProvaBloccata.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneDirezioneBloccata() {
		String prova = "Stanza bloccata nella direzione: ovest"+"\nPrendi il piedediporco e posalo nella stanza";
		assertEquals(prova, stanzaDiProvaBloccata.getDescrizione());
		
	}

}