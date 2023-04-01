package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.Stanza;

public class StanzaTest {
	Stanza atrio = new Stanza("atrio");
	Stanza biblioteca = new Stanza("biblioteca");
	Attrezzo ascia = new Attrezzo("ascia", 8);
	
	@Test
	public void testaddAttrezzo() {
		System.out.println("Sto eseguendo testaddAttrezzo()");
		assertTrue(this.atrio.addAttrezzo(ascia));
	}
	
	@Test
	public void testremoveAttrezzo() {
		System.out.println("Sto eseguendo testremoveAttrezzo()");
		biblioteca.addAttrezzo(ascia);
		assertEquals(true, biblioteca.removeAttrezzo(ascia));
	}
	
	@Test
	public void testimpostaStanzaAdiacente() {
		System.out.println("Sto eseguendo testimpostaStanzaAdiacente()");
		assertNull(atrio.getStanzaAdiacente("sud"));
	}
}
