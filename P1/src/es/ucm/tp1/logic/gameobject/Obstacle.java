	package es.ucm.tp1.logic.gameobject;

import es.ucm.tp1.logic.Game;

public class Obstacle {
/*	Comportamiento: No se mueve. El coche muere cuando choca contra 茅l.
	Resistencia: 1 punto de resistencia (en futuras extensiones tendremos muros m谩s
	fuertes y el usuario podr�? dispararles o tirarles bombas).
*/
	private Game game;
	
	private boolean alive;
	private int x;
	private int y;
	private final static String SYMBOL = "░";//░
	public Obstacle(Game game, int x, int y) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.alive = true;
	}
	public void update() {// no hace nada
		
	}
	
	public boolean isInPosition(int x, int y) {
		return x == this.x && y == this.y;
	}
	public String toString() {
		return SYMBOL;
	}
	protected void receiveCollision(Player p) {
		alive = false;
	}
	protected boolean isAlive() {
		return alive;
	}
	//aux
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
