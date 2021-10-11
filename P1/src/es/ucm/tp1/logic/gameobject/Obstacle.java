	package es.ucm.tp1.logic.gameobject;

import es.ucm.tp1.logic.Game;

public class Obstacle {
/*	Comportamiento: No se mueve. El coche muere cuando choca contra 茅l.
	Resistencia: 1 punto de resistencia (en futuras extensiones tendremos muros m谩s
	fuertes y el usuario podr�? dispararles o tirarles bombas).
*/
	private Game game;
	
	private static int Resistencia = 1;
	private static int x;
	private static int y;
	private final static String SYMBOL = "�?";
	public Obstacle(Game game) {
		this.game = game;
		
	}
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
