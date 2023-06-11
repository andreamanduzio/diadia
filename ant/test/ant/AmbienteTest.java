package ant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AmbienteTest {
	private Ambiente ambiente;
	
	@Before
	public void SetUp() {
		this.ambiente = new Ambiente();
	}
	
	private Cibo creaCibo() {
		Random rnd = new Random();
		final Cibo cibo = new Cibo(new Coordinate(rnd.nextInt()%30, rnd.nextInt()%30));
		return cibo;
	}
	
	@Test
	public void aggiungiOstacoloTest() {
		this.ambiente.aggiungiOstacolo(new Coordinate(0, 0));
		assertTrue(this.ambiente.suOstacolo(new Coordinate(0, 0)));
	}
	@Test
	public void addCiboTest() {
		Cibo c1 = this.creaCibo();
		Cibo c2 = this.creaCibo();
		Cibo c3 = this.creaCibo();
		this.ambiente.addCibo(c1);
		this.ambiente.addCibo(c2);
		this.ambiente.addCibo(c3);
		Collection<Cibo> expected = new HashSet<>();
		expected.add(c1);
		expected.add(c2);
		expected.add(c3);
		assertTrue(verifica(expected, ambiente.getCibo()));
	}

	private boolean verifica(Collection<Cibo> expected, Collection<Cibo> passed) {
		for(Object c : passed) {
			if(!passed.contains(c))
				return false;
		}
		return true;
	}

	@Test
	public void getPossibiliDirezioniTest() {
		this.ambiente.aggiungiOstacolo(new Coordinate(11,11));
		this.ambiente.aggiungiOstacolo(new Coordinate(9,9));
		this.ambiente.aggiungiOstacolo(new Coordinate(11,9));
		this.ambiente.aggiungiOstacolo(new Coordinate(9,11));
		
		this.ambiente.aggiungiOstacolo(new Coordinate(10,11));
		this.ambiente.aggiungiOstacolo(new Coordinate(10,9));
		this.ambiente.aggiungiOstacolo(new Coordinate(11,10));
		this.ambiente.aggiungiOstacolo(new Coordinate(9,10));
		assertEquals(Collections.EMPTY_SET, this.ambiente.getPossibiliDirezioni(new Coordinate(10, 10)));
	}

	@Test
	public void getPossibiliDirezioniTestUnica() {
		this.ambiente.aggiungiOstacolo(new Coordinate(11,11));
		this.ambiente.aggiungiOstacolo(new Coordinate(9,9));
		this.ambiente.aggiungiOstacolo(new Coordinate(11,9));
		this.ambiente.aggiungiOstacolo(new Coordinate(9,11));
		
		this.ambiente.aggiungiOstacolo(new Coordinate(10,11));
		this.ambiente.aggiungiOstacolo(new Coordinate(10,9));
		this.ambiente.aggiungiOstacolo(new Coordinate(9,10));
		assertEquals(Collections.singleton(new Direzione(1, 0)), this.ambiente.getPossibiliDirezioni(new Coordinate(10, 10)));
	}
	
	@Test
	public void getPossibiliDirezioniTestDue() {
		this.ambiente.aggiungiOstacolo(new Coordinate(9,9));
		this.ambiente.aggiungiOstacolo(new Coordinate(11,9));
		this.ambiente.aggiungiOstacolo(new Coordinate(9,11));
		
		this.ambiente.aggiungiOstacolo(new Coordinate(10,11));
		this.ambiente.aggiungiOstacolo(new Coordinate(10,9));
		this.ambiente.aggiungiOstacolo(new Coordinate(9,10));
		Set<Direzione> direzioniPossibili = new HashSet<>();
		direzioniPossibili.add(new Direzione(1, 1));
		direzioniPossibili.add(new Direzione(1, 0));
		assertTrue(verificaDirezioni(direzioniPossibili, this.ambiente.getPossibiliDirezioni(new Coordinate(10, 10))));
	}
	

	private boolean verificaDirezioni(Collection<Direzione> expected, Collection<Direzione> passed) {
		for(Object c : passed) {
			if(!passed.contains(c))
				return false;
		}
		return true;
	}
}
