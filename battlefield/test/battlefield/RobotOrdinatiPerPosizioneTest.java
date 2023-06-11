package battlefield;

import static org.junit.Assert.*;

import org.junit.*;

public class RobotOrdinatiPerPosizioneTest {
	
	// (vedi DOMANDA 5)
	// scrivere dei test-case minimali per il metodo
	// Battlefield.getRobotOrdinatiPerPosizione()
	
	@Test
	public void testRobotOrdinatiPerPosizioneFieldVuoto() {
		Battlefield field = new Battlefield(0);
		assertEquals(0, field.getRobotOrdinatiPerPosizione().size());
	}
	
	@Test
	public void testRobotOrdinatiPerPosizione1Robot() {
		Battlefield field = new Battlefield(2);
		Chaser c = new Chaser(new Position(0, 0));
		field.addrobot(c);
		assertEquals(1, field.getRobotOrdinatiPerPosizione().size());
	}
	
	@Test
	public void testRobotOrdinatiPerPosizioneXDiverse() {
		Battlefield field = new Battlefield(2);
		Walker w = new Walker(new Position(1, 1));
		field.addrobot(w);
		Chaser c = new Chaser(new Position(0, 0));
		field.addrobot(c);
		assertSame(c, field.getRobotOrdinatiPerPosizione().get(0));
		assertSame(w, field.getRobotOrdinatiPerPosizione().get(1));
	}
	
	@Test
	public void testRobotOrdinatiPerPosizioneXUgualiYdiversa() {
		Battlefield field = new Battlefield(2);
		Walker w = new Walker(new Position(0, 1));
		field.addrobot(w);
		Chaser c = new Chaser(new Position(0, 0));
		field.addrobot(c);
		assertSame(c, field.getRobotOrdinatiPerPosizione().get(0));
		assertSame(w, field.getRobotOrdinatiPerPosizione().get(1));
	}
	
	@Test
	public void testRobotOrdinatiPerPosizione4Robot() {
		Battlefield field = new Battlefield(2);
		Walker w = new Walker(new Position(0, 1));
		field.addrobot(w);
		Chaser c = new Chaser(new Position(0, 0));
		field.addrobot(c);
		Walker w2 = new Walker(new Position(2, 1));
		field.addrobot(w2);
		Chaser c2 = new Chaser(new Position(1, 0));
		field.addrobot(c2);
		assertSame(c, field.getRobotOrdinatiPerPosizione().get(0));
		assertSame(w, field.getRobotOrdinatiPerPosizione().get(1));
		assertSame(c2, field.getRobotOrdinatiPerPosizione().get(2));
		assertSame(w2, field.getRobotOrdinatiPerPosizione().get(3));
	}
	
	
}
