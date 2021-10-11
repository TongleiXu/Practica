package es.ucm.tp1.logic.gameobject;

import es.ucm.tp1.logic.Game;

public class Player {
/*	Comportamiento: Avanza, va hacia arriba o va hacia abajo.
	Velocidad: 1 casilla por turno.
	Resistencia: Muere automáticamente con una colisión.*/
	private static int speed = 1;
	private static boolean alive = true;
	private static int x;
	private static int y;
	private static int coin;
	private final static String SYMBOL_A = ">";
	private final static String SYMBOL_C = "@";
	
	private Game game;
	
	public Player(Game g, int posx, int posy) {
		game = g;
		x = posx;
		y= posy;
		coin = 0;
	}
	public void update(){
		x += speed;
		if(doCollision(game.getCoinInPosition(x, y))) {
			addCoins(1);
		}
		else if(doCollision(game.getObstacleInPosition(x, y))) {
			crashed();
		}
			
	}	
	public boolean isInPosition(int relativeX, int posy) {
		return relativeX == x && posy == y;
	}
	
	public String toString() {
		if(alive)
			return SYMBOL_A;
		else
			return SYMBOL_C;
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	
	public void goUp() {
		--y;
	}
	public void goDown() {
		++y;
	}
	
	
	private boolean doCollision(Coin c) {
		if(c != null) {
			c.receiveCollision(this);
			return true;
		}
		return false;
	}
	private boolean doCollision (Obstacle o) {
		if (o != null) {
			o.receiveCollision(this);
			return true;
		}
		return false;
	}
	private void addCoins(int add) {
		coin += add;
	}
	/*private void subCoins(int sub) {
		coin -= sub;
	}*/
	
	public int getCoin() {
		return coin;
	}
	private void crashed() {
		alive = false;
	}
	
	//aux
	public boolean isAlive() {
		return alive;
	}
	
}
