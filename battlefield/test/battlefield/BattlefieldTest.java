package battlefield;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/* Modificare la classe Position affinche' 
 * il primo test abbia successo (vedi DOMANDA 1) 
 */
public class BattlefieldTest {
	
	private Battlefield field;
	
	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(2);
	}

	@Test
	public void testAddWalker() {
		assertEquals(0, this.field.getAllRobots().size());
		this.field.addrobot(new Walker(new Position(0,0)));
		assertEquals(1, this.field.getAllRobots().size());
	}
	
	@Test
	public void testRaggruppaRobotFieldVuoto() {
		assertTrue(this.field.raggruppaRobotPerTipo().isEmpty());
	}
	
	@Test
	public void testRaggruppaRobotUnTipo() {
		Walker walkerSolitario = new Walker(new Position(0,0));
		this.field.addrobot(walkerSolitario);
		assertEquals(1, this.field.raggruppaRobotPerTipo().size());
	}
	
	@Test
	public void testRaggruppaRobotDiDueTipiDiversi() {
		Chaser chaserSolitario = new Chaser(new Position(1,1));
		this.field.addrobot(chaserSolitario);
		Walker walkerSolitario = new Walker(new Position(0,0));
		this.field.addrobot(walkerSolitario);
		Map<Class, Set<Robot>> doubleTon = new HashMap<>();
		doubleTon.put(Walker.class, Collections.singleton(walkerSolitario));
		doubleTon.put(Chaser.class, Collections.singleton(chaserSolitario));
		assertEquals(doubleTon, this.field.raggruppaRobotPerTipo());
	}

}
