package es.ucm.tp1.logic_gameobject;

public class Player {
/*	Comportamiento: Avanza, va hacia arriba o va hacia abajo.
	Velocidad: 1 casilla por turno.
	Resistencia: Muere automáticamente con una colisión.*/
	private final static int SPEED = 1;
	private static boolean Resistencia = true;
	private static int x;
	private static int y;
	private static int coin;
	private final static String SYMBOL_A = ">";
	private final static String SYMBOL_C = "@";
	
	public Player(int x, int y) {
		this.x = x;
		this.y= y;
		coin = 0;
	}
	
	
}
