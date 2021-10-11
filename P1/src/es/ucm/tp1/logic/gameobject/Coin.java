package es.ucm.tp1.logic.gameobject;

public class Coin {
	
/*Comportamiento: No se mueve. 
 * Cuando el coche pasa por encima, el jugador incrementa su
 *  n煤mero de monedas en 1 unidad y el objeto Coin desaparece
*/
	
	
	private final static String a = "¢";
	private int x;
	private int y;
	public Coin(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	void receiveCollision(Player player) {
		
		/*que proceso hago si el player choca con una coin:
			o le doy la coin
			o la coin deja de estar viva 
*/
	}
	public boolean isInPosition(int relativeX, int y) {
		return relativeX == getX() && y == getY();
	}
	public String toString() {
		return a;
	}
	
	/*public void update() {
		// TODO Auto-generated method stub
		
	}
	*/
	
	//aux
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
