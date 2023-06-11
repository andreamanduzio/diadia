package battlefield;

import java.util.Objects;

/*
 * Da sistemare. Vedi PositionTest.
 * (vedi DOMANDA 1)
 */
public class Position {
	
	private int x, y;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
		
	public String toString() {
		return this.x+"-"+this.y;
	}

	@Override
	public int hashCode() {
		return this.getX() + this.getY();
	}

	@Override
	public boolean equals(Object o) {
		Position that = (Position) o;
		return (this.getX() == that.getX() && this.getY() == that.getY());
	}
	

}