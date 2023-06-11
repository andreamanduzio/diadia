package ant.simulatore;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ant.Cibo;
import ant.Coordinate;
import ant.formica.Esploratrice;
import ant.formica.Formica;
import ant.formica.Inseguitrice;

@SuppressWarnings("unused")
public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	
	
	final private Coordinate origine = new Coordinate(0, 0);
	
	private Esploratrice formica ;
	private Inseguitrice altraFormica ;
	
	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
		this.formica = this.simulatore.creaEsploratrice();
		this.altraFormica = this.simulatore.creaInseguitrice();
	}

	@After
	public void tearDown() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field progIdE = Esploratrice.class.getDeclaredField("progId");
		progIdE.setAccessible(true);
		progIdE.setInt(null, 0);
		
		Field progIdI = Inseguitrice.class.getDeclaredField("progId");
		progIdI.setAccessible(true);
		progIdI.setInt(null, 0);
	}
	
	private Cibo creaCiboRaccoltoDaEsploratore() {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(this.simulatore.creaEsploratrice());	
		return cibo;
	}

	private Cibo creaCiboRaccoltoDaInseguitore() {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(this.simulatore.creaInseguitrice());	
		return cibo;
	}

	@Test
	public void testRaccoltoPerFormicaDueFormiche() {
		// DA COMPLETARE ( VEDI DOMANDA 3 ) SUGG.: USARE I METODI FACTORY SOPRA
		Cibo c = this.creaCiboRaccoltoDaEsploratore();
		Cibo c2 = this.creaCiboRaccoltoDaEsploratore();
		c.setRaccoglitrice(formica);
		c2.setRaccoglitrice(formica);
		Set<Cibo> set = new HashSet<>();
		set.add(c);
		set.add(c2);
		Map<Formica, Integer> expected = new HashMap<>();
		expected.put(formica, 2);
		assertEquals(expected, stats.raccoltoPerFormica(set));
	}
	

	@Test
	public void testRaccoltoPerFormica() {
		// DA COMPLETARE ( VEDI DOMANDA 3 ) SUGG.: USARE I METODI FACTORY SOPRA
		Cibo c = this.creaCiboRaccoltoDaEsploratore();
		c.setRaccoglitrice(formica);
		Map<Formica, Integer> expected = Collections.singletonMap(formica, 1);
		assertEquals(expected, stats.raccoltoPerFormica(Collections.singleton(c)));
	}
	
	@Test
	public void testRaccoltoPerTipoDiFormica() {
		// DA COMPLETARE ( VEDI DOMANDA 4 ) SUGG.: USARE I METODI FACTORY SOPRA
		Cibo c = this.creaCiboRaccoltoDaEsploratore();
		Cibo c2 = this.creaCiboRaccoltoDaInseguitore();
		Cibo c3 = this.creaCiboRaccoltoDaInseguitore();
		c.setRaccoglitrice(formica);
		c2.setRaccoglitrice(altraFormica);
		c3.setRaccoglitrice(altraFormica);
		Set<Cibo> raccolto = new HashSet<>();
		raccolto.add(c);
		raccolto.add(c2);
		raccolto.add(c3);
		Map<Class<?>, Set<Cibo>> expected = new HashMap<>();
		expected.put(formica.getClass(), Collections.singleton(c));
		Set<Cibo> miniSet = new HashSet<>();
		miniSet.add(c2);
		miniSet.add(c3);
		expected.put(altraFormica.getClass(), miniSet);
		assertEquals(expected, stats.raccoltoPerTipoDiFormica(raccolto));
	}
	
}
