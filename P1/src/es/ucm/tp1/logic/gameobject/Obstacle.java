	package es.ucm.tp1.logic.gameobject;

import es.ucm.tp1.logic.Game;

public class Obstacle {
/*	Comportamiento: No se mueve. El coche muere cuando choca contra èŒ…l.
	Resistencia: 1 punto de resistencia (en futuras extensiones tendremos muros mè°©s
	fuertes y el usuario podrè°? dispararles o tirarles bombas).
*/
	private Game game;
	
	private static int Resistencia = 1;
	private static int x;
	private static int y;
	private final static String SYMBOL = "â–?";
	public Obstacle(Game game) {
		this.game = game;
		
	}
}
