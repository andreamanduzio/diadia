package ama.simulatore;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ama.Citta;
import ama.Posizione;
import ama.mezzo.Brown;
import ama.mezzo.Chase;
import ama.mezzo.Mezzo;
import ama.mezzo.Pendo;
import ama.rifiuto.Carta;
import ama.rifiuto.Organico;
import ama.rifiuto.Rifiuto;
import ama.rifiuto.Vetro;

public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	
	
	final static private Posizione ORIGINE = new Posizione(0, 0);
	
	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
	}
	
	@After
	public void tearDown() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Field progIdB = Brown.class.getDeclaredField("progId");
		progIdB.setAccessible(true);
		progIdB.setInt(null, 0);
		
		Field progIdC = Chase.class.getDeclaredField("progId");
		progIdC.setAccessible(true);
		progIdC.setInt(null, 0);
		
		Field progIdP = Pendo.class.getDeclaredField("progId");
		progIdP.setAccessible(true);
		progIdP.setInt(null, 0);
	}

	/* N.B. E' POSSIBILE USARE I  METODI CHE SEGUONO (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	private Vetro creaVetroRaccoltoDaBrowniano() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaBrowniano());	
		return rifiuto;
	}

	
	private Vetro creaVetroRaccoltoDaChaser() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaChaser());	
		return rifiuto;
	}
	
	/* N.B. E' POSSIBILE USARE I METODI SOPRA (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	
	@Test
	public void testRaccoltoPerMezzo() {
		/* DA COMPLETARE VEDI DOMANDA 3 */
		Mezzo m1 = new Mezzo(simulatore, new Brown());
		Mezzo m2 = new Mezzo(simulatore, new Chase(new Citta()));
		Rifiuto r1 = new Carta(new Posizione(0, 0));
		Rifiuto r2 = new Vetro(new Posizione(0, 0));
		Rifiuto r3 = new Organico(new Posizione(0, 0));
		r1.setRaccoglitore(m1);
		r2.setRaccoglitore(m2);
		r3.setRaccoglitore(m2);
		Set<Rifiuto> set = new HashSet<>();
		set.add(r1);
		set.add(r2);
		set.add(r3);
		Map<Mezzo, Integer> expected = new HashMap<>();
		expected.put(m1, 1);
		expected.put(m2, 2);
		assertEquals(expected, stats.raccoltoPerMezzo(set));
	}

	
	@Test
	public void testRaccoltoPerPolitica() {
		/* DA COMPLETARE VEDI DOMANDA 4 */
		Mezzo m1 = new Mezzo(simulatore, new Brown());
		Mezzo m2 = new Mezzo(simulatore, new Chase(new Citta()));
		Rifiuto r1 = new Carta(new Posizione(0, 0));
		Rifiuto r2 = new Vetro(new Posizione(0, 0));
		Rifiuto r3 = new Organico(new Posizione(0, 0));
		r1.setRaccoglitore(m1);
		r2.setRaccoglitore(m2);
		r3.setRaccoglitore(m2);
		Set<Rifiuto> set = new HashSet<>();
		set.add(r1);
		set.add(r2);
		set.add(r3);
		Map<Class<?>, Integer> expected = new HashMap<>();
		expected.put(m1.getPolitica().getClass(), 1);
		expected.put(m2.getPolitica().getClass(), 2);
		assertEquals(expected, stats.raccoltoPerPolitica(set));
	}
	
	/*                              */
	/* DA COMPLETARE VEDI DOMANDA 6 */
	/*                              */
	@Test
	public void ordinaPolitichePerRaccoltaUno() {
		Map<Class<?>, Integer> mappa = new HashMap<>();
		Mezzo m1 = new Mezzo(simulatore, new Brown());
		mappa.put(m1.getPolitica().getClass(), 1);
		List<Class<?>> expected = new ArrayList<>();
		expected.add(m1.getPolitica().getClass());
		assertEquals(expected, stats.ordinaPolitichePerRaccolta(mappa));
	}
	
	@Test
	public void ordinaPolitichePerRaccoltaDue() {
		Map<Class<?>, Integer> mappa = new HashMap<>();
		Mezzo m1 = new Mezzo(simulatore, new Brown());
		Mezzo m2 = new Mezzo(simulatore, new Chase(new Citta()));
		mappa.put(m1.getPolitica().getClass(), 1);
		mappa.put(m2.getPolitica().getClass(), 2);
		List<Class<?>> expected = new ArrayList<>();
		expected.add(m2.getPolitica().getClass());
		expected.add(m1.getPolitica().getClass());
		assertEquals(expected, stats.ordinaPolitichePerRaccolta(mappa));
	}
	
	
	@Test
	public void ordinaPolitichePerRaccoltaTre() {
		Map<Class<?>, Integer> mappa = new HashMap<>();
		Mezzo m1 = new Mezzo(simulatore, new Brown());
		Mezzo m2 = new Mezzo(simulatore, new Chase(new Citta()));
		Mezzo m3 = new Mezzo(simulatore, new Pendo(new Citta()));
		mappa.put(m1.getPolitica().getClass(), 1);
		mappa.put(m2.getPolitica().getClass(), 2);
		mappa.put(m3.getPolitica().getClass(), 6);
		List<Class<?>> expected = new ArrayList<>();
		expected.add(m3.getPolitica().getClass());
		expected.add(m2.getPolitica().getClass());
		expected.add(m1.getPolitica().getClass());
		assertEquals(expected, stats.ordinaPolitichePerRaccolta(mappa));
	}
}
