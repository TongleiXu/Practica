package es.ucm.tp1.logic.gameobject;

public class Player {
/*	Comportamiento: Avanza, va hacia arriba o va hacia abajo.
	Velocidad: 1 casilla por turno.
	Resistencia: Muere automáticamente con una colisión.*/
	private final static int SPEED = 1;
	private static boolean Resistencia = true;
	private int x;
	private int y;
	private int coin;
	private final static String SYMBOL_A = ">";
	private final static String SYMBOL_C = "@";
	
	
	public Player(int x, int y) {
		this.x = x;
		this.y= y;
		coin = 0;
	}
	public void update(){
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean isInPosition(int relativeX, int y) {
		return relativeX == getX() && y == getY();
	}
	
	public String toString() {
		if(Resistencia)
			return SYMBOL_A;
		else
			return SYMBOL_C;
		
	}
}
