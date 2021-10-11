package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobject.*;
import es.ucm.tp1.view.GamePrinter;

public class Game {
	private GamePrinter printer;
	private Player player;
	private Obstacle obstacles;
	private Coin coins;
	private Level level;	
	private Random rand;
	
	
	private long seed;
	private boolean TestMode;
	private int numObs;
	private int numCoins;
	private int cycles;
	private static boolean testMode = false;
	
	//3.1
	public Game(Long seed, Level level, boolean isTestMode) {
		this.seed = seed;
		this.level = level;
		//record
		this.TestMode = isTestMode;
		//Y llama al reset() en su ¨²ltima instrucci¨®n
		reset();
	}
	//3.2
	public String getInfo() {
		StringBuilder str = new StringBuilder();
		str.append("\n Available objects: \n" +		
					"[Car] the racing car\n" +
					"[Coin] gives 1 coin to the player\n" +
					"[Obstacle] hits car)\n");
		return str.toString();
	}
	//3.3
	public void update() {
		//update player
		player.update();
		//Remueve muertos de las listas: removeDead
		coins.update();
		obstacles.update();	
		// suma uno al ciclo actual 
		cycle += 1;
				
	}
	//3.8
	public String positionToString(int x, int y) {
		
		StringBuilder str = new StringBuilder();
		int relativeX = player.getX() + x;
		if (player.isInPosition(relativeX, y))
			str.append(player);
		else if()
		return str.toString();
	}
	public void toggleTest() {
		// TODO Auto-generated method stub
		testMode = true;
	}
	
	public String toString() {
		return printer.toString();
	}
	public String getGameStatus() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("estado...\n");
		return str.toString();
	}
	
	//COMMAND-------------------------------------------------
	public void goUp() {
		// TODO Auto-generated method stub
		
	}
	public void goDown() {
		// TODO Auto-generated method stub
		
	}
	public void reset() {
		printer = new GamePrinter(this,level.getVisibility(),level.getRoadWidth());
		player = new Player(0, 1);//posicion inicial player(x, y)
		rand = new Random(seed);
		
		this.cycles = 0;
		
		
				
	}
	public void setTestMode() {
		this.TestMode = true;
	}
	//-----------------------------------------------------------------
	//metodo auxiliar
	void inicializaci¨®n() {
		
	}
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getEndGameMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
