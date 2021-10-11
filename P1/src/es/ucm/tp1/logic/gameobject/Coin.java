package es.ucm.tp1.logic.gameobject;

import es.ucm.tp1.logic.Game;

public class Coin {
	
/*Comportamiento: No se mueve. 
 * Cuando el coche pasa por encima, el jugador incrementa su
 *  numero de monedas en 1 unidad y el objeto Coin desaparece
*/
	
	//¢
	private final static String SYMBOL = "¢";
	private int x;
	private int y;
	private boolean alive;
	private Game game;
	
	public Coin(Game g, int x, int y) {
		this.x = x;
		this.y = y;
		game = g;
		this.alive = true;
		
	}
	
	public boolean isInPosition(int x, int y) {
		return x == this.x && y == this.y;
	}
	public String toString() {
		return SYMBOL;
	}
	
	public void update() {//no hace nada
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
