package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic_gameobject.*;
import es.ucm.tp1.view.GamePrinter;

public class Game {
	private GamePrinter printer;
	private Player player;
	private Obstacle obstacles;
	private Coin coins;
	private Level level;
	
	private Random rand;
	private long seed;
	
	private static boolean testMode = false;
	
	
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
		printer = new GamePrinter(this,level.getLength(),level.getWidth());
	}
	public String positionToString(int x, int y) {
		StringBuilder str = new StringBuilder();
		
		return str.toString();
	}
	public void toggleTest() {
		// TODO Auto-generated method stub
		testMode = true;
	}
	
	public String toString() {
		return printer.toString();
	}
	public Object getGameStatus() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("estado...\n");
		return str;
	}
}
