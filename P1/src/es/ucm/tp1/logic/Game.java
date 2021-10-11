package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobject.*;
import es.ucm.tp1.view.GamePrinter;

public class Game {
	private GamePrinter printer;
	private Player player;
	private ObstacleList obstacles;
	private CoinList coins;
	private Level level;	
	private Random rand;
	
	private long initialTime;
	private long seed;
	private boolean TestMode;
	private static int cicles;
	private static int distance;
	private static String  endMsg;
	private static boolean exit;
	private final static String META = "¦";
	
	//3.1
	public Game(Long seed, Level level, boolean isTestMode) {
		this.seed = seed;
		this.level = level;
		this.TestMode = isTestMode;
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
		player.update();
		coins.removeDead();
		// suma uno al ciclo actual 
		cicles ++;
		distance--;	
	}
	//3.4
	public void reset() {
		printer = new GamePrinter(this,level.getVisibility(),level.getRoadWidth());
		player = new Player(this, 0, 1);//posicion inicial player(x, y)
		rand = new Random(seed);
		cicles = 0;
		distance = level.getRoadLength() - player.getX();
		initialTime = System.currentTimeMillis();
		exit = false;
		
		obstacles = new ObstacleList(level.getRoadLength() * level.getRoadWidth());
		coins = new CoinList(level.getRoadLength() * level.getRoadWidth());
		
		for(int x = getVisibility()/2; x < getRoadLength(); x++) {
			tryToAddObstacle(new Obstacle(this, x, getRandomWidth()),
			level.obstacleFrequency());
			tryToAddCoin(new Coin(this, x, getRandomWidth()),
			level.coinFrequency()); 
		}
	}
	//3.5
	public String getEndGameMessage() {
		return endMsg;
	}
	public boolean isFinished() {
		if(exit == true) {
			endMsg = "Player leaves the game";
			return true;
		}
		else if(!player.isAlive()) {
			endMsg = "Player crashed!";
			return true;
		}
		else if(distance == 0) {
			endMsg = "Player wins!";
			return true;
		}
		return false;
	}
	//3.6
	private void tryToAddObstacle(Obstacle o, double frequency) {
		if(getRandomNumber() < frequency &&
			coins.isPositionEmpty(o.getX(), o.getY()) &&
			obstacles.isPositionEmpty(o.getX(), o.getY())) {
				obstacles.add (o);
		}
		
	}
	private void tryToAddCoin(Coin c, double frequency) {
		if(getRandomNumber() < frequency &&
				coins.isPositionEmpty(c.getX(), c.getY()) &&
				obstacles.isPositionEmpty(c.getX(), c.getY())) 			
					coins.add (c);
	}
	//3.7
	private double getRandomNumber() {
		return rand.nextDouble();
	}
	
	//3.8
	public String positionToString(int x, int y) {
		StringBuilder str = new StringBuilder();
		int relativeX = player.getX() + x;
		if (player.isInPosition(relativeX, y))
			str.append(player);
		else if(!coins.isPositionEmpty(relativeX, y))
			str.append(getCoinInPosition(relativeX, y));
		else if(!obstacles.isPositionEmpty(relativeX, y))
			str.append(getObstacleInPosition(relativeX, y));
		else if(relativeX == level.getRoadLength())
			str.append(META);
		return str.toString();
	}
	public void toggleTest() {
		TestMode = true;
	}
	
	public String toString() {
		return printer.toString();
	}
	public String getGameStatus() {
		StringBuilder str = new StringBuilder();
		str.append("Distance: " + distance +
					"\nCoins: " + player.getCoin() +
					"\nCicle: " + cicles +
					"\nTotal obstacles: " + obstacles.getObstaclesCount() +
					"\nTotal coins: " + coins.getCoinCount());
		if(!TestMode)
			str.append("\nEllapsed Time: " + (System.currentTimeMillis() - initialTime) + " s");
		return str.toString();
	}
	
	//COMMAND-------------------------------------------------
	public void goUp() {
		player.goUp();
		update();
	}
	public void goDown() {
		player.goDown();
		update();
	}
	
	public void setTestMode() {
		this.TestMode = true;
	}
	public void exit() {
		exit = true;
	}
	//-----------------------------------------------------------------
	
	public Coin getCoinInPosition (int x, int y) {
		return coins.getObjectInPosition(x, y);
	}
	public Obstacle getObstacleInPosition (int x, int y) {
		return obstacles.getObjectInPosition(x, y);
	}
	
	//metodo auxiliar
	
	private int getVisibility() {
		return level.getVisibility();
	}
	private int getRoadLength() {
		return level.getRoadLength();
	}
	private int getRandomWidth() {
		return (int) (getRandomNumber()*level.getRoadWidth());
	}
	
	
}
